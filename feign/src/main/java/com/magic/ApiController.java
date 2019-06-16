package com.magic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Chelsea
 * @Date 2019/6/16 20:14
 */
@RestController
public class ApiController {

    @Autowired
    private  ApiService apiService;

    @RequestMapping("index")
    public String index(){
        return apiService.index();
    }
}
