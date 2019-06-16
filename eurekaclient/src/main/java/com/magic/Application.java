package com.magic;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Description
 * @Author Chelsea
 * @Date 2019/6/13 20:59
 */
@SpringCloudApplication
public class Application {

//    @SpringCloudApplication 注解包含了 @EnableDiscoveryClient 注解，因此无需显式开启服务发现。
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    在实际的项目中，一个项目可能会包含很多个服务，每个服务的端口和 IP 都可能不一样。那么，如果我们以这种形式提供接口给外部调用，代价是非常大的。从安全性上考虑，系统对外提供的接口应该进行合法性校验，防止非法请求，如果按照这种形式，那每个服务都要写一遍校验规则，维护起来也很麻烦。
//
//    这个时候，我们需要统一的入口，接口地址全部由该入口进入，而服务只部署在局域网内供这个统一的入口调用，这个入口就是我们通常说的服务网关。
//
//    Spring Cloud 给我们提供了这样一个解决方案，那就是 zuul，它的作用就是进行路由转发、异常处理和过滤拦截。下面，我将演示如果使用 zuul 创建一个服务网关。
}
