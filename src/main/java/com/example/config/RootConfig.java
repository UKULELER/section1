package com.example.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;


@Configuration
@Import({DataConfig.class,CachingConfig.class})
//@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = {"com.example"},
    excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
//    public static class WebPackage extends RegexPatternTypeFilter {
//        public WebPackage(){
//            super((Pattern.compile("com\\.example\\.web")));
//        }
//    }
}
