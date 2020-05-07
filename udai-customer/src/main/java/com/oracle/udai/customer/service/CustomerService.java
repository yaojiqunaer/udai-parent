package com.oracle.udai.customer.service;

import com.oracle.udai.common.JsonBean;

/**
 * @ClassName CustomerService
 * @Description: 用户管理的业务层接口
 * @Author zhangxiaodong
 * @Date 2020/5/1 13:19
 * @Version V1.0
 */
public interface CustomerService {

    JsonBean login(String username, String password);
}
