package com.panshi.ybei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger访问地址：http://localhost:8081/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2//启动swagger
public class UserSwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.panshi.ybei"))//指定扫描controller包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("友贝UserApl")//接口标题
                .description("User用户接口")//接口具体描述
                .termsOfServiceUrl("http://192.168.1.153:8081/")//调用服务地址
                .contact(new Contact("爱吃湘菜不爱吃香菜","http://test.com","498397648@qq.com"))//联系我们信息
                .version("version 1.0")//定义版本号
                .build();
    }
}
