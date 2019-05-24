/**
 * 111
 */

package com.mmall.concurrency;

import com.mmall.concurrency.example.threadLocal.RequstHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        log.info("do filter ,  {} ,  {}",Thread.currentThread().getId(),req.getServletPath());
        RequstHolder.add(Thread.currentThread().getId());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
