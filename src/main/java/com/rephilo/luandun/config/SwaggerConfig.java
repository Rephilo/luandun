package com.rephilo.luandun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 *
 * @author rephilo
 */
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = "com.rephilo.luandun.controller")
public class SwaggerConfig {

    @Bean
    public Docket luandunApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("不知道为什么就想加个API文档")
                .description("说出来你可能不信，就是我拿来写着玩的服务")
//                .termsOfServiceUrl("http://springfox.io")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .contact(new Contact("呵呵", "http://没有博客.com", "rephilo@163.com"))
                .build();
    }
//
//    @Bean
//    public UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .deepLinking(true)
//                .displayOperationId(false)
//                .defaultModelsExpandDepth(1)
//                .defaultModelExpandDepth(1)
//                .defaultModelRendering(ModelRendering.EXAMPLE)
//                .displayRequestDuration(false)
//                .docExpansion(DocExpansion.NONE)
//                .filter(false)
//                .maxDisplayedTags(null)
//                .operationsSorter(OperationsSorter.ALPHA)
//                .showExtensions(false)
//                .tagsSorter(TagsSorter.ALPHA)
//                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//                .validatorUrl(null)
//                .build();
//    }


    @Bean
    public WebMvcConfigurer enableSwaggerUI() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html")
                        .addResourceLocations("classpath:/META-INF/resources/");

                registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
            }
        };
    }
}
