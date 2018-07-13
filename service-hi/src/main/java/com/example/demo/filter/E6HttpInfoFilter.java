package com.example.demo.filter;

import org.springframework.cloud.sleuth.instrument.web.SleuthWebProperties;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

@Order
public class E6HttpInfoFilter extends GenericFilterBean {
    private Pattern skipPattern = Pattern.compile(SleuthWebProperties.DEFAULT_SKIP_PATTERN);
    private String[] headers;

    public E6HttpInfoFilter() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("Filter just supports HTTP requests");
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean skip = skipPattern.matcher(httpRequest.getRequestURI()).matches();
        Enumeration<String> names =  httpRequest.getHeaderNames();
        System.out.println("head begin ---");
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println("http header:"+name+"="+httpRequest.getHeader(name));
        }
        System.out.println("head end ---");
        /*String userToken = httpRequest.getHeader("userToken");
        if(userToken==null){
            System.out.println("set head userToken");
            Span span = tracer.getCurrentSpan();
            span.setBaggageItem("userToken","100000001");
        }else{
            System.out.println("userToken="+userToken);
        }*/

        chain.doFilter(request, response);
    }
}
