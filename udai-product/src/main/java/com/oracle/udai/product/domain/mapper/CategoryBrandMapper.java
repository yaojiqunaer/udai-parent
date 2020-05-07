package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.product.domain.dto.CategoryBrand;
import com.oracle.udai.product.domain.dto.CategoryBrandKey;

public interface CategoryBrandMapper {
    int deleteByPrimaryKey(CategoryBrandKey key);

    int insert(CategoryBrand record);

    int insertSelective(CategoryBrand record);

    CategoryBrand selectByPrimaryKey(CategoryBrandKey key);

    int updateByPrimaryKeySelective(CategoryBrand record);

    int updateByPrimaryKey(CategoryBrand record);
}