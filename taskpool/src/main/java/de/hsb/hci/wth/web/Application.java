package de.hsb.hci.wth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "de.hsb.hci.wth.web")
@ServletComponentScan({ "de.hsb.hci.wth.web" })
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    // return application.sources(Application.class, SecurityConfig.class);
    // }
}
