package com.example.rollerShop.db.interceptors;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;


@Slf4j
public class LogRequestBodyInterceptor extends GenericFilterBean {
    //TODO сделай так чтобы каждый реквест (неваржно какой post put delete)логировался
    //а именно чтобы видно было url реквеста его хедеры
    //так же если есть тело запроса оно тоже должно выводиться в логи @Slf4j
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        MultiReadHttpServletRequest multiReadHttpServletRequest = new MultiReadHttpServletRequest(request);

        String method = multiReadHttpServletRequest.getMethod();
        String url = multiReadHttpServletRequest.getRequestURL().toString();
        String headers = Collections.list(multiReadHttpServletRequest.getHeaderNames()).stream()
                .map(headerName -> headerName + ": " + multiReadHttpServletRequest.getHeader(headerName))
                .collect(Collectors.joining(", "));


        String body = "";
        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE")) {
            body = IOUtils.toString(multiReadHttpServletRequest.getReader());
        }

        String logMessage = String.format("Request: %s %s, Headers: {%s}, Body: %s", method, url, headers, body);
        log.info(logMessage);
        filterChain.doFilter(multiReadHttpServletRequest, servletResponse);
    }
}
