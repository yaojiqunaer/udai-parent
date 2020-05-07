package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.product.domain.dto.SpecParam;

public interface SpecParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecParam record);

    int insertSelective(SpecParam record);

    SpecParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecParam record);

    int updateByPrimaryKey(SpecParam record);
}