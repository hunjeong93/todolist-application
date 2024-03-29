package com.codestates.board.config;

import com.codestates.board.filter.HttpServletWrappingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    public FilterRegistrationBean<HttpServletWrappingFilter> firstFilterRegister()  {
        FilterRegistrationBean<HttpServletWrappingFilter> registrationBean =
                new FilterRegistrationBean<>(new HttpServletWrappingFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);

        return registrationBean;
    }
}
