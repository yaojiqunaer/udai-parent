package com.oracle.udai.apigateway.filter.postFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ResponseFilter
 * @Description: 响应过滤器
 * @Author zhangxiaodong
 * @Date 2020/5/1 17:16
 * @Version V1.0
 */
@Component
public class ResponseFilter extends ZuulFilter {


    /**
     * @param
     * @return
     * @description 过滤类型为post
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * @param
     * @return
     * @description 优先级 999
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    /**
     * @param
     * @return
     * @description 开启过滤条件
     */
    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("SB","you");
        return null;
    }
}
