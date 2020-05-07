package com.oracle.udai.product.controller;

import com.oracle.udai.common.JsonBean;
import com.oracle.udai.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Description: 商品的控制器
 * @Author zhangxiaodong
 * @Date 2020/4/29 19:55
 * @Version V1.0
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * @param id
     * @return
     * @description 根据商品ID获取商品信息
     */
    @RequestMapping("getProductById")
    public JsonBean getProductById(@RequestBody Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务被调用了");
        return productService.getProductById(id);
    }

    /**
     * @param
     * @return
     * @description 商品分类层级
     */
    @RequestMapping("getCategories")
    public JsonBean getCategories() {
        return productService.getCategorys();
    }

    /**
     * @param categoryId 商品分类ID
     * @return
     * @description 查询产品列表信息
     */
    @RequestMapping("getSpusByCategoryId")
    public JsonBean getSpus(Integer categoryId) {
        return productService.getSpus(categoryId);
    }

    /**
     * @param spuId 产品ID
     * @return
     * @description 根据产品ID获取商品集合 含最低价格和图片
     */
    @RequestMapping("getProductsBySpuId")
    public JsonBean getProductsBySpuId(Integer spuId) {
        return productService.getProductsBySpuId(spuId);
    }

    /**
     * @param
     * @return
     * @description 将商品信息放到redis
     */
    @RequestMapping("putProductsToRedis")
    public JsonBean putProductsToRedis() {
        return productService.putProductsToRedis();
    }

}
