package springCloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springCloud.service.HelloService;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@RestController
@RefreshScope
@EnableDiscoveryClient
public class ServiceRibbonApplication {
    public static void main(String[] args){
        SpringApplication.run(ServiceRibbonApplication.class,args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private HelloService helloService;
    @RequestMapping("/")
    public String Hello() {
        return helloService.getHelloConfig();
    }
    @RequestMapping("/hello")
    public String helloe() {
        return helloService.getHelloConfig();
    }
}
