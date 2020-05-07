package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.product.domain.dto.SpecGroup;

public interface SpecGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecGroup record);

    int insertSelective(SpecGroup record);

    SpecGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecGroup record);

    int updateByPrimaryKey(SpecGroup record);
}