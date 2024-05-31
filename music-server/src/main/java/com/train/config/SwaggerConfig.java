package com.train.config;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * api页面 /doc.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled:true}")
    private Boolean enabled;

    @Bean
    @SuppressWarnings("all")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://localhost:8082")
                .enable(enabled)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.train.controller"))
                .paths(PathSelectors.regex("^(?!/error).*"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("音乐接口文档")
                .description("SpringBoot音乐网站开发")
                .version("1.0")
                .contact(new Contact("liuhongjun", "http://localhost:8082/doc.html", "3236447743@qq.com"))
                .build();
    }

}
