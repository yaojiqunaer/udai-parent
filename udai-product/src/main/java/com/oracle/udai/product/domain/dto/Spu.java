package com.oracle.udai.product.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 产品
 * @return
 */
@Data
public class Spu {
    private Integer id;

    private String title;

    private String subTitle;

    private Integer categoryId;//分类ID

    private Integer brandId;//品牌ID

    private Integer spgId;

    private Boolean saleable;

    private Boolean valid;

    private Date createTime;

    private Date lastUpdateTime;

    private Boolean isDelete;//是否删除（禁用）

    private BigDecimal price;//该产品最低价

}