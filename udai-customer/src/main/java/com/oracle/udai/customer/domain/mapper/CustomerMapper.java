package com.oracle.udai.customer.domain.mapper;

import com.oracle.udai.customer.domain.dto.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    Customer login(Customer customer);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}