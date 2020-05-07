package com.oracle.udai.product.service.impl;

import com.oracle.udai.api.vo.SkuVO;
import com.oracle.udai.common.JsonBean;
import com.oracle.udai.product.domain.dto.Category;
import com.oracle.udai.product.domain.dto.Sku;
import com.oracle.udai.product.domain.dto.Spu;
import com.oracle.udai.product.domain.mapper.CategoryMapper;
import com.oracle.udai.product.domain.mapper.SkuMapper;
import com.oracle.udai.product.domain.mapper.SpuMapper;
import com.oracle.udai.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description: 商品的业务层实现
 * @Author zhangxiaodong
 * @Date 2020/4/29 20:01
 * @Version V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * @return
     * @description 将product信息放到redis数据库
     */
    @Override
    public JsonBean putProductsToRedis() {
        List<Sku> skus = skuMapper.selectAllList();
        if (skus == null) {
            return new JsonBean(-1, "系统异常", null);
        }
        if (skus.size() == 0) {
            return new JsonBean(-2, "暂无商品数据", null);
        }
        for (Sku sku : skus) {
            //商品信息存入redis
            //redisTemplate.opsForValue().set("product_" + sku.getId(), JSON.toJSON(sku).toString());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "id", sku.getId());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "spuId", sku.getSpuId());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "title", sku.getTitle());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "images", sku.getImages());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "seckill", sku.getSeckill());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "startTime", sku.getStartTime());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "endTime", sku.getEndTime());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "count", sku.getCount());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "price", sku.getPrice());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "param", sku.getParam());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "saleable", sku.getSaleable());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "valid", sku.getValid());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "createTime", sku.getCreateTime());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "lastUpdateTime", sku.getLastUpdateTime());
            redisTemplate.opsForHash().put("product_" + sku.getId(), "isDeleted", sku.getIsDeleted());
            // System.out.println(redisTemplate.opsForValue().get("product_" + sku.getId()));
            //System.out.println(redisTemplate.opsForHash().get("product_" + sku.getId(), "id"));


        }
        return new JsonBean(0, "OK", null);
    }

    /**
     * @param id
     * @return
     * @description 根据商品ID获取商品信息
     */
    @Override
    public JsonBean getProductById(Integer id) {
        SkuVO skuVO = skuMapper.selectByPrimaryKey(id);
        if (skuVO == null) {
            return new JsonBean(-1, "商品不存在", null);
        }
        return new JsonBean(0, "OK", skuVO);
    }


    /**
     * @param spuId 产品ID
     * @return
     * @description 根据产品ID获取商品集合 含最低价格和图片
     */
    @Override
    public JsonBean getProductsBySpuId(Integer spuId) {
        List<Sku> skus = skuMapper.selectBySpuId(spuId);
        return new JsonBean(0, "OK", skus);
    }

    /**
     * @param categoryId 商品分类ID
     * @return
     * @description 获取分类的款式
     */
    @Override
    public JsonBean getSpus(Integer categoryId) {
        /*
         1. 首先根据ID查询分类
         2. 判断该分类下是否还有分类
         3. 如果有需要获取下级的分类
         4. 没有则直接查询
         */
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category == null) {
            return new JsonBean(-1, "无数据信息", null);
        }
        List<Integer> categoryIds = new ArrayList<>();
        List<Category> categories = null;
        if (category.getIfParent()) {
            //分类下还有子类则查询子类
            categories = categoryMapper.selectListByParentId(categoryId);
            categories = this.forListCategoryToList(categories);//递归查询 返回当前分类和所有子类集合
            for (Category category1 : categories) {
                categoryIds.add(category1.getId());//封装所有id
            }

        }
        categoryIds.add(categoryId);
        //查询产品信息
        List<Spu> spus = spuMapper.selectSpuListByCategoryIds(categoryIds);
        for (Spu spu : spus) {
            //查询产品最低价
            spu.setPrice(spuMapper.selectSpuLowPriceBySkuId(spu.getId()));
            //查询产品图片（从商品表中查询）
        }
        return new JsonBean(0, "OK", spus);
    }

    /**
     * @param categories
     * @return
     * @description 根据分类递归查询子分类
     * 将子分类也封装集合
     */
    private List<Category> forListCategoryToList(List<Category> categories) {
        List<Category> resultCategories = new ArrayList<>();
        for (Category category : categories) {
            resultCategories.add(category);
            if (category.getIfParent()) {
                //含有子分类 则查询子分类
                List<Category> childCategories = categoryMapper.selectListByParentId(category.getId());
                //递归查询子类并封装
                this.forListCategoryToList(childCategories);
            }
        }
        return resultCategories;
    }


    /**
     * @return
     * @description 获取商品分类
     */
    @Override
    public JsonBean getCategorys() {
        JsonBean jsonBean = new JsonBean(-1, "error", null);
        /*
         * 从redis查询分类
         */
        List<Category> redisCategories = (List<Category>) redisTemplate.opsForValue().get("categories");
        if (redisCategories != null && redisCategories.size() > 0) {
            return new JsonBean(0, "Ok", redisCategories);
        }
        List<Category> categories = categoryMapper.selectListByParentId(0);
        if (categories != null & categories.size() > 0) {
            //递归封装商品分类子类
            categories = this.forListCategoryToSelf(categories);
            jsonBean = new JsonBean(0, "OK", categories);
        }
        //分类json数据存入redis中
        redisTemplate.opsForValue().set("categories", categories);
        return jsonBean;
    }


    /**
     * @param categories
     * @return
     * @description 递归查询子分类
     * 将子分类封装到Category的属性List<Category> childCategories
     */
    private List<Category> forListCategoryToSelf(List<Category> categories) {
        for (Category category : categories) {
            if (category.getIfParent()) {
                //含有子分类 则查询子分类
                List<Category> childCategories = categoryMapper.selectListByParentId(category.getId());
                category.setChildCategories(childCategories);
                //递归查询子类并封装
                this.forListCategoryToSelf(childCategories);
            }
        }
        return categories;
    }
}
