package com.oracle.udai.order.domain.mapper;

import com.oracle.udai.order.domain.dto.OrderDetail;
import com.oracle.udai.order.domain.dto.OrderDetailKey;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(OrderDetailKey key);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(OrderDetailKey key);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}