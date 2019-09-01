package com.yuejulala;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class YjllGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(YjllGatewayApplication.class,args);
    }
}