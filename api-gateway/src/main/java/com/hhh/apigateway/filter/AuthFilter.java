package com.hhh.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author hhh
 * @date 2020/2/29 14:16
 * @description 权限校验
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * true 需要拦截，false不需要，可以根据具体的业务逻辑来判断，确认拦截后，拦截后具体的处理逻辑写在run()方法中
     * @return 是否需要拦截
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体权限校验逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
