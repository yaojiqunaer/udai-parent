package com.oracle.udai.product.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * 商品分类
 */
@Data
public class Category {

    private Integer id;

    private String name;//分类名

    private Integer parentId;//上级分类ID

    private Boolean ifParent;//

    private Integer sort;//排序

    private Boolean isDeleted;

    private List<Category> childCategories;//子分类

}