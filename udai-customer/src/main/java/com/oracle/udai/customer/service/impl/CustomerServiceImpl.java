package com.oracle.udai.customer.service.impl;

import com.oracle.udai.api.vo.CustomerVO;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.customer.domain.dto.Customer;
import com.oracle.udai.customer.domain.mapper.CustomerMapper;
import com.oracle.udai.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName CustomerServiceImpl
 * @Description: 用户管理业务层实现
 * @Author zhangxiaodong
 * @Date 2020/5/1 13:20
 * @Version V1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public JsonBean login(String username, String password) {

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer = customerMapper.login(customer);
        return new JsonBean(0, "OK", this.convertToVoObject(customer));
    }

    private CustomerVO convertToVoObject(Customer customer) {
        if (Objects.isNull(customer)) {
            return null;
        }
        CustomerVO customerVO = new CustomerVO();
        customerVO.setId(customer.getId());
        customerVO.setCreateTime(customer.getCreateTime());
        customerVO.setIsDeleted(customer.getIsDeleted());
        customerVO.setLastUpdateTime(customer.getLastUpdateTime());
        customerVO.setLevelId(customer.getLevelId());
        customerVO.setPassword(customer.getPassword());
        customerVO.setSalt(customer.getSalt());
        customerVO.setTel(customer.getTel());
        customerVO.setUsername(customer.getUsername());
        customerVO.setWechat(customer.getWechat());
        return customerVO;
    }
}
