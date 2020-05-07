package com.oracle.udai.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
    private Integer id;

    private String code;

    private Byte type;

    private Integer shopId;

    private Integer customerId;

    private BigDecimal amount;

    private Byte paymentType;

    private Byte status;

    private BigDecimal postage;

    private Integer weight;

    private Integer voucherId;

    private Date createTime;

    private Boolean isDeleted;

}