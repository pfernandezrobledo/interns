package com.avanade.interns.middleware;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*
THE PROBLEM:
Which HttpServletRequest are talking about???
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/HandlerInterceptor.html

Difference between Filters and HandlerInterceptors
https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter
*/
public class SampleInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {

        System.out.println("HELLO FROM SAMPLE INTERCEPTOR preHandle!!!!!!");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
      throws Exception {

        System.out.println("HELLO FROM SAMPLE INTERCEPTOR postHandle!!!!!!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
      throws Exception {

        System.out.println("HELLO FROM SAMPLE INTERCEPTOR afterCompletion!!!!!!");
    }
}
