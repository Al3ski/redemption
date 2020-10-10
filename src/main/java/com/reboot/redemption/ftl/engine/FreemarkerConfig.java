package com.reboot.redemption.ftl.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.TimeZone;

@Configuration
public class FreemarkerConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().setTimeZone(TimeZone.getTimeZone("UTF"));
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freemarker.template.Configuration freemarkerConfig = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_30);
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
        freemarkerConfig.setDefaultEncoding("UTF-8");
        freeMarkerConfigurer.setConfiguration(freemarkerConfig);
        return freeMarkerConfigurer;
    }
}
