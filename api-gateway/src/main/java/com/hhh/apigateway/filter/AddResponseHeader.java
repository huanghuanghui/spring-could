package com.hhh.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * @author hhh
 * @date 2020/2/29 10:02
 * @description 在情求到了目标服务返回结果之后，对结果进行加工
 */
@Component
public class AddResponseHeader extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
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
     * 获取返回值后，往返回值信息的header中写入信息
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        final RequestContext currentContext = RequestContext.getCurrentContext();
        final HttpServletResponse response = currentContext.getResponse();
        response.setHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
