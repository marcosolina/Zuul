package com.marco.zuul;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimpleFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        String url = request.getRequestURI();

        if(url.contains("v2")){

            return false;

        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "pre";
    }

    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 1;
    }
}
