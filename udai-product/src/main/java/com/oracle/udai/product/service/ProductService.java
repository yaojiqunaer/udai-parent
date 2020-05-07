package com.oracle.udai.product.service;

import com.oracle.udai.common.JsonBean;

/**
 * @ClassName ProductService
 * @Description: 商品的业务层接口
 * @Author zhangxiaodong
 * @Date 2020/4/29 20:00
 * @Version V1.0
 */
public interface ProductService {

    /**
     * @param
     * @return
     * @description 获取商品分类
     */
    JsonBean getCategorys();

    /**
     * @param categoryId 商品分类ID
     * @return
     * @description 获取产品列表
     */
    JsonBean getSpus(Integer categoryId);

    /**
     * @param spuId 产品ID
     * @return
     * @description 根据产品ID获取商品集合 含最低价格和图片
     */
    JsonBean getProductsBySpuId(Integer spuId);

    /**
     * @param
     * @return
     * @description 将product信息放到redis数据库
     */
    JsonBean putProductsToRedis();

    /**
     * @param id
     * @return
     * @description 根据商品ID获取商品信息
     */
    JsonBean getProductById(Integer id);
}
