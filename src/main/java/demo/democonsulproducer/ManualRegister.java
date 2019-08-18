package demo.democonsulproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

/**
 * for testing manual register consul service
 *
 */
@Component
public class ManualRegister {

	@Autowired
	private Environment environment;
	
	public boolean register() {
		
		try {

			// do stuff
			ConsulClient client = new ConsulClient("localhost");

			// Get the port
			String port = environment.getProperty("server.port");
			if (port == null)
				return false;

			// Get the app name
			String appName = environment.getProperty("spring.application.name");

			// Fix underscores
			appName = appName.replace('_', '-');

			// register new service
			NewService newService = new NewService();
			newService.setId(appName + "-" + port);
			newService.setName(appName);
			newService.setPort(Integer.parseInt(port));

			// Add the health check
			NewService.Check serviceCheck = new NewService.Check();
			serviceCheck.setHttp("http://localhost:" + port + "/health");
			serviceCheck.setInterval("10s");

			// register the health check
			newService.setCheck(serviceCheck);

			// register the service
			client.agentServiceRegister(newService);

		} catch (Exception e) {

			// Oops
			e.printStackTrace();

		}
		
		
		return true;
	}
	
	
}
