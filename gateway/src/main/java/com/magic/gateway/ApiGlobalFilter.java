package com.magic.gateway;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Chelsea
 * @Date 2019/6/13 21:39
 */
public class ApiGlobalFilter implements GlobalFilter {
    /**
     * 通过重写 filter 方法，由于 Gateway 依赖 WebFlux，因此这里也返回的是 Mono 对象，通过 Mono 返回数据到前端，
     * 上述代码，我们首先取得 token 参数，判断 token 是否存在，如果不存在则返回鉴权失败，这只是一个最简单的鉴权例子，
     * 具体的鉴权实现根据具体的项目来考虑。
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)) {
            ServerHttpResponse response = exchange.getResponse();
            Map<String,Object> message = new HashMap<>();
            message.put("status", -1);
            message.put("data", "鉴权失败");
            byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }
}
