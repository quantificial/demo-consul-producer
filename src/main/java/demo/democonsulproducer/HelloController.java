package demo.democonsulproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment env;
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello consul >> " + env.getProperty("CONSUL_NAME");
    }
    
    @RequestMapping("/hello2")
    public String hello2() {
        return "hello again consul >> " + env.getProperty("CONSUL_NAME");
    }
    
    @RequestMapping("/hello3")
    public String greeting(@RequestParam(value="id", defaultValue="uniqueId") String id ) {
    	return id;
    }
}