package com.oracle.udai.product.domain.mapper;

import com.oracle.udai.api.vo.SkuVO;
import com.oracle.udai.product.domain.dto.Sku;

import java.util.List;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sku record);

    int insertSelective(Sku record);

    SkuVO selectByPrimaryKey(Integer id);

    List<Sku> selectSkuByCategoryId(Integer categoryId);

    /**
     * @param spuId
     * @return
     * @description 根据产品id查询商品
     */
    List<Sku> selectBySpuId(Integer spuId);


    /**
     * @param
     * @return
     * @description 查询所有商品
     */
    List<Sku> selectAllList();

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

}