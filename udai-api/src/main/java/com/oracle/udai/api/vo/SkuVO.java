package com.oracle.udai.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SkuVO {
    private Integer id;

    private Integer spuId;

    private String title;

    private Object images;

    private Boolean seckill;

    private Date startTime;

    private Date endTime;

    private Integer count;

    private BigDecimal price;

    private Object param;

    private Boolean saleable;

    private Boolean valid;

    private Date createTime;

    private Date lastUpdateTime;

    private Boolean isDeleted;

}