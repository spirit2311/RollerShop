package com.example.rollerShop.db.interceptors;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;


public class LogRequestBodyInterceptor extends GenericFilterBean {
    //TODO сделай так чтобы каждый реквест (неваржно какой post put delete)логировался
    //а именно чтобы видно было url реквеста его хедеры
    //так же если есть тело запроса оно тоже должно выводиться в логи @Slf4j
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
