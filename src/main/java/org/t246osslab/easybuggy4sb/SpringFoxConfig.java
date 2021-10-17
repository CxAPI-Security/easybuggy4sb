package org.t246osslab.easybuggy4sb;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Locale;

import static org.t246osslab.easybuggy4sb.WebSecurity.AUTH_PATH_SWAGGER_REGEX;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(oauth()))
                .securityContexts(Arrays.asList(securityContext()))
                .ignoredParameterTypes(Locale.class)
                .alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(ModelAndView.class),
                        typeResolver.resolve(WildcardType.class)));
    }

    @Bean
    SecurityScheme oauth() {
       return new BasicAuth("basic_auth");
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId("http_client")
                .clientSecret(null)
                .realm("basic_auth")
                .appName("easybuggy4sb")
                .scopeSeparator(" ")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("basic_auth", scopes())))
                .forPaths(PathSelectors.regex(AUTH_PATH_SWAGGER_REGEX))
                .build();
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[] {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations")
        };
    }
}