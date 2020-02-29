package com.hhh.apigateway.properties;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @author hhh
 * @date 2020/2/29 11:20
 * @description 跨域配置
 */
public class CrossOriginConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config =new CorsConfiguration();
        config.setAllowCredentials(true);
        //原始域 域名
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setExposedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        //缓存时间 300s
        config.setMaxAge(300L);
        //路径设置为所有
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter();
    }
}
