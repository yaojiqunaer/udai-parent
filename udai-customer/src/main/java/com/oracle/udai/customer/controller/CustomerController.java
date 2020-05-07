package com.oracle.udai.customer.controller;

import com.oracle.udai.common.JsonBean;
import com.oracle.udai.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomerController
 * @Description: TODO
 * @Author zhangxiaodong
 * @Date 2020/4/29 17:54
 * @Version V1.0
 */
@RestController
public class CustomerController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CustomerService customerService;

    /**
     * @param username
     * @param password
     * @param request
     * @return
     * @description
     */
    @PostMapping("login")
    public JsonBean login(String username, String password, HttpServletRequest request) {
        String sessionId = request.getHeader("sessionId");//获取zuul中过滤器设置的sessionId
        System.out.println(sessionId);
        System.out.println(request.getSession().getId());
        JsonBean jsonBean = customerService.login(username, password);
        //登录成功  session作为健  用户信息作为值放入redis
        redisTemplate.opsForValue().set(sessionId, jsonBean.getData());
        System.out.println(redisTemplate.opsForValue().get(sessionId));
        return new JsonBean(0, "OK", jsonBean);
    }

    @PostMapping("register")
    public JsonBean register() {
        return new JsonBean(0, "OK", null);

    }

}
