package com.hhh.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.hhh.apigateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @author hhh
 * @date 2020/2/29 9:52
 * @description Zuul限流
 * 时机：情求转发之前被调用
 */
public class RateLimitFilter extends ZuulFilter {

    /**
     * 谷歌提供的令牌桶算法
     * create 为每秒往桶中放入多少个令牌
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    /**
     * true 需要拦截，false不需要，可以根据具体的业务逻辑来判断，确认拦截后，拦截后具体的处理逻辑写在run()方法中
     * @return 是否需要拦截
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMITER.tryAcquire()){
            throw new RateLimitException("获取令牌桶令牌失败");
        }
        return null;
    }
}
