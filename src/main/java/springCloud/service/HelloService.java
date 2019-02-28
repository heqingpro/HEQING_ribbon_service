package springCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String getHelloConfig(){
        return  restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
    }
}
