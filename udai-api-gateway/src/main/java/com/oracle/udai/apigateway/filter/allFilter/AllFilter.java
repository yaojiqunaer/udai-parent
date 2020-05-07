package com.oracle.udai.apigateway.filter.allFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @ClassName AllFilter
 * @Description: 过滤所有请求
 * @Author zhangxiaodong
 * @Date 2020/5/2 12:55
 * @Version V1.0
 */
@Component
public class AllFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //优先级   3  比登录优先级高
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String sessionId = requestContext.getRequest().getSession().getId();
        /*
         * zuul路由到个服务的每次请求的session都一致
         */
        requestContext.addZuulRequestHeader("sessionId", sessionId);//方便所有路由的服务都能拿到相同sessionId
        requestContext.setSendZuulResponse(true);
        return null;
    }
}
