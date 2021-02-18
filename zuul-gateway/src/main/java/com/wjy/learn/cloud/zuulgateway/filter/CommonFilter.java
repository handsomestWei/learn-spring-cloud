package com.wjy.learn.cloud.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
// 自动更新配置
@RefreshScope
public class CommonFilter extends ZuulFilter {

    @Value("${commonFilter.flag}")
    boolean flag;

    @Override
    public String filterType() {
        //		pre：路由之前
//		routing：路由之时
//		post： 路由之后
//		error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return flag;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        System.out.println("CommonFilter==>>>> "+req.getRequestURI());
        return null;
    }
}
