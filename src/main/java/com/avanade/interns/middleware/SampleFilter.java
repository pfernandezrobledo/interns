package com.avanade.interns.middleware;

import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
THE PROBLEM:

Difference between Filters and HandlerInterceptors
https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter
*/

@Component
public class SampleFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    System.out.println("HELLO FROM SAMPLE ONCE PER REQUEST FILTER doFilterInternal!!!!!!");

    filterChain.doFilter(request, response);
  }

}
