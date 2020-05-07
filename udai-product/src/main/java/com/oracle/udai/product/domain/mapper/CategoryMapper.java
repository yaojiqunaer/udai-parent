package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.product.domain.dto.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectListByParentId(Integer parentId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}