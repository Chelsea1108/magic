package com.magic;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Chelsea
 * @Date 2019/6/16 20:11
 */
@Component
public class ApiServiceError implements ApiService {
    @Override
    public String index() {
        return "服务发生故障!";
    }
}
