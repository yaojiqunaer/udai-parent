package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.product.domain.dto.Spu;

import java.math.BigDecimal;
import java.util.List;

public interface SpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Spu record);

    int insertSelective(Spu record);

    Spu selectByPrimaryKey(Integer id);

    /**
     * @param categoryIds 分类ID集合
     * @return
     * @description 根据分类ID集合查询产品信息
     */
    List<Spu> selectSpuListByCategoryIds(List<Integer> categoryIds);

    /**
     * @param skuId
     * @return
     * @description 根据Sku的ID查询最低价
     */
    BigDecimal selectSpuLowPriceBySkuId(Integer skuId);

    int updateByPrimaryKeySelective(Spu record);

    int updateByPrimaryKey(Spu record);

}