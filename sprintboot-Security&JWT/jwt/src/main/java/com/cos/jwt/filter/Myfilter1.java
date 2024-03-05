package com.cos.jwt.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.parameters.P;

import java.io.IOException;
import java.io.PrintWriter;


public class Myfilter1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        /** 토큰 : id,pw가 정상정으로 들어와서 로그인이 완료 되면 토큰을 만들어주고 그걸 응답을 해준다.
         * 요청 할때마다 header에 Authorization에 vaule값으로 토큰을 가지고옴
         * 그때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증만 하면 됨. (RSA, HS256)
         */

        System.out.println("필터1" + req.getMethod());
        String headerAuth = req.getHeader("Authorization");
//        if(headerAuth.equals("cos")) {
//            filterChain.doFilter(req, res);
//        }else {
//            PrintWriter printWriter = res.getWriter();
//            printWriter.println("인증안됨");
//        }
        System.out.println(headerAuth);
        System.out.println("필터1");

        filterChain.doFilter(req, res);
    }
}
