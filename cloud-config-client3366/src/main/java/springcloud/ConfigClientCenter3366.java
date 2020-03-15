package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * USER: wang_s
 * DATE：2020/3/15
 * DESC：
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientCenter3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCenter3366.class,args);
    }
}
