package com.oracle.udai.apigateway.filter.loginFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginFilter
 * @Description: 登录验证，鉴权操作
 * @Author zhangxiaodong
 * @Date 2020/5/1 15:07
 * @Version V1.0
 */
@Component
public class LoginFilter extends ZuulFilter {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param
     * @return
     * @description 过滤类型为前置过滤
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * @param
     * @return
     * @description 过滤优先级，数值小优先级高
     * 优先级为 4
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * @param
     * @return true为开启 false为放过
     * @description 是否开启过滤
     * 不需过滤直接返回false
     * 需要过滤则返回true
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        if (uri.contains("/order/")) {
            //拦截订单请求
            return true;//开启过滤 验证登录
        }
        return false;
    }

    /**
     * @param
     * @return
     * @description 过滤执行的操作，验证登录
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String sessionId = request.getSession().getId();
        /*
         * 返回对象为CustomerVO
         */
        System.out.println(redisTemplate.hasKey(sessionId));
        System.out.println(redisTemplate.opsForValue().get(sessionId));
        if (redisTemplate.opsForValue().get(sessionId) == null) {
            //未登录
            requestContext.setSendZuulResponse(false);
            //状态码为401未授权
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
