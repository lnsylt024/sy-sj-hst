package com.app.hst.common.filter;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(value = "Token过滤器")
@Slf4j
public class TokenFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("TokenFilter....init()");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("TokenFilter....doFilter()");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //URI
        String uri = request.getRequestURI();
        //contextPath
        String contextPath=request.getContextPath();

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        LOGGER.info("TokenFilter....destroy()");
        Filter.super.destroy();
    }
}
 