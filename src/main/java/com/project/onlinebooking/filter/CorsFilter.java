package com.project.onlinebooking.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Client www.yyy.com/index.html
//Server www.xxx.com/search?lat=10&lon=100

//1. browser send OPTIONS https://www.xxx.com /search?lat=10&lon=100 ~to check if browser can response correctly
//2. Return Access-Control-Allow-Origin: www.vicent.com, www.hello.com
//          Access-Control-Allow-Headers:
//          Access-Control-Allow-Methods:
//3. Browser check headers, then decide if we can continue
//4. GET https://www.xxx.com /search?lat=10&lon=100
//5. Return stay information

//spring component, decouple~ create a bean(create a object for the class)
//order: the first one in the filter chain
//request -> cors -> jwt -> auth -> controller
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*"); // * all inclusive
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

        //if through all the filters, get to the controller
        //how many filters to filter the register request? around 20 filters

        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
