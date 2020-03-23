package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * USER: wang_s
 * DATE：2020/3/22
 * DESC：
 **/
@RestController
@Slf4j
public class NacosPaymentController {
    @Value("${server.port}")
    private String serverPort;

        @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string + "==>serverPort:"+serverPort;
    }
}
