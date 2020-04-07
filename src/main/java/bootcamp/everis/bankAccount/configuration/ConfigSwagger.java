package bootcamp.everis.bankAccount.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class ConfigSwagger {
    @Bean
    public Docket BankAccountApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("bootcamp.everis.bankAccount"))
                .paths(regex("/BankAccount.*"))
                .build()
                .apiInfo(apiInfoEndPoints());
    }

    private ApiInfo apiInfoEndPoints() {
        return new ApiInfoBuilder()
                .title("Microservice BankAccount Rest Api")
                .description("Documentation BankAccount Management Rest Api")
                .contact(new Contact("Pedro Luis Barros Valle","https://github.com/pbarrosv","pbarrosv@everis.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
