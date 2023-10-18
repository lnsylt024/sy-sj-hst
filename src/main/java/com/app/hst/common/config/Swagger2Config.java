package com.app.hst.common.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Swagger2配置")
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .globalOperationParameters(setHeader());
    }
    private List<Parameter> setHeader(){
        List<Parameter> pars = new ArrayList<>();
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).defaultValue("1").parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//
//        ParameterBuilder auditPar = new ParameterBuilder();
//        auditPar.name("signature").description("signature").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(auditPar.build());
//
//        ParameterBuilder languagePar = new ParameterBuilder();
//        languagePar.name("Accept-Language").description("Language").modelRef(new ModelRef("string")).defaultValue("ja-JP").parameterType("header").required(false).build();
//        pars.add(languagePar.build());
        return pars;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("API文档描述")
                .termsOfServiceUrl("http://example.com/")
                .contact(new Contact("ShenyangHST", "http://www.baidu.com","lnsylt@163.com"))
                .version("1.0")
                .build();
    }
}
