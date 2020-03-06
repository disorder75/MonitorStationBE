package it.unimi.nc.be.monitor.station.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {      
	
    @Value("${station.controller.swagger2.basePackage}")
	private String basePackage;
    @Value("${application.version}")
	private String version;
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).select()
        											  .apis(RequestHandlerSelectors.basePackage(basePackage))
        											  .paths(PathSelectors.any())
        											  .build()
        											  .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo("Monitor Station IoT API", "microservices for iot applications", version, "", "Nunzio Castelli", "Università degli Studi di Milano", "https://www.unimi.it/it");
    }
}