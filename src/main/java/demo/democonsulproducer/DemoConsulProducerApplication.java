package demo.democonsulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoConsulProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConsulProducerApplication.class, args);
	}

}
