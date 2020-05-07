package com.oracle.udai.order.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDetail extends OrderDetailKey {
    private BigDecimal price;

    private BigDecimal actualPrice;

    private Integer num;

    private Boolean isDeleted;

}