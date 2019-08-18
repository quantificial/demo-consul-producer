package demo.democonsulproducer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.catalog.model.CatalogService;


//@Slf4j
@Component
//@RequiredArgsConstructor
@ConditionalOnProperty(value = "spring.cloud.consul.enabled")
public class ConsulRegistrationHealthIndicator extends AbstractHealthIndicator {
    public static final String APPLICATION_NAME_KEY = "spring.application.name";
    //public static final String HOSTNAME_KEY = "spring.cloud.consul.host";
    public static final String HOSTNAME_KEY = "spring.cloud.client.ipAddress";
    public static final String SERVICE_KEY = "spring.cloud.consul.discovery.serviceName";
    public static final String PORT_KEY = "server.port";

    @Autowired
    private Environment environment;
    
    @Autowired
    private ConsulClient client;


    protected void doHealthCheck(Health.Builder builder) {
    	builder.withDetail("foo", "bar");
//        String applicationName = environment.getRequiredProperty(APPLICATION_NAME_KEY);
//        //String address = environment.getRequiredProperty(HOSTNAME_KEY);
//        Integer servicePort = environment.getRequiredProperty(PORT_KEY, Integer.class);
//
//        try {
//            Response<List<CatalogService>> services = this.client.getCatalogService(applicationName, QueryParams.DEFAULT);
//            Optional<CatalogService> catalogService = services.getValue().stream()
//                    //.filter(service -> service.getServiceAddress().equals(address))s
//                    //.filter(service -> service.getServicePort().equals(servicePort))
//                    .filter(service -> service.getServiceId().equals(applicationName+"-"+servicePort))
//                    .findAny();
//
//            //builder.up()
//            if (catalogService.isPresent()) {
//                builder.up();
//                System.out.println("up up up ");
//            } else {
//                builder.down();
//                System.out.println("down down down ");
//            }
//        } catch (Exception e) {
//            //log.error("Couldn't query catalog service for {}", applicationName, e);
//            System.out.println("Couldn't query catalog service for {} " + applicationName + e);
//            builder.down(e);
//        }

    }
}