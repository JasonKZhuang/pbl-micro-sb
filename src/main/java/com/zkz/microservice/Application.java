package com.zkz.microservice;

import com.github.javafaker.Faker;
import com.zkz.microservice.entity.Product;
import com.zkz.microservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);

        //If you don’t want command line properties to be added to the Environment you can disable them using
        //application.setAddCommandLineProperties(false);

        //print out all the arguments
        System.out.println("===>The application is running with parameters:");
        for(String arg:args) {
            System.out.println(arg);
        }

        //run the application instance
        application.run(args);
    }

    /**
     * Synchronous(TongBu) client to perform HTTP requests,
     * exposing a simple, template method API over underlying HTTP client libraries such as the JDK HttpURLConnection, Apache HttpComponents, and others.
     * The RestTemplate offers templates for common scenarios by HTTP method,
     * in addition to the generalized exchange and execute methods that support of less frequent cases.
     * For example, the restTemplate can be injected to service to cal other Http endpoints
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate(){
//        return  new RestTemplate();
//    }

    /**
     * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
     * Interface used to indicate that a bean should run when it is contained within a SpringApplication.
     * Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered interface or @Order annotation.
     * @param ctx
     * @return
     */
    @Bean
    @Order(1)
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("1 ===================================>>> Let's inspect the beans provided by Spring Boot <<<====");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                // System.out.println(beanName);
            }

        };
    }

    //Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
    @Bean
    @Order(2)
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            System.out.println("2 ==========Let's insert some new products into the database =================");
            log.info("Preloading " + repository.save(new Product("Bilbo Baggins")));
            log.info("Preloading " + repository.save(new Product("Frodo Baggins")));
            for (int i =0; i < 10; i++) {
                Product p = new Product(
                        new Faker().book().title(),
                        new Faker().number().randomDouble(2, 10, 100),
                        new Faker().number().numberBetween(1, 100)
                );
                repository.save(p);
            }
        };
    }

}
