package com.oracle.udai.apigateway.filter.seckillFilter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SeckillFilter
 * @Description: 秒杀业务、令牌桶
 * @Author zhangxiaodong
 * @Date 2020/5/1 17:31
 * @Version V1.0
 */
@Component
public class SeckillFilter extends ZuulFilter {


    //令牌为300个
    private final RateLimiter RATE_LIMITER = RateLimiter.create(50);


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //优先级  -4
    @Override
    public int filterOrder() {
        //优先级高于登录
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        if (uri.contains("/seckill/createOrder")) {
            //拦截秒杀请求
            return true;//开启过滤
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        if (!RATE_LIMITER.tryAcquire()) {
            //没有抢到令牌
            response.setStatus(HttpStatus.SC_ACCEPTED);
        }
        return null;
    }
}
