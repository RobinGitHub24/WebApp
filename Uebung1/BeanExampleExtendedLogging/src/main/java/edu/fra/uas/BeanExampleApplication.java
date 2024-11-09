package edu.fra.uas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import edu.fra.uas.controller.BeanController;

@SpringBootApplication
public class BeanExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(BeanExampleApplication.class);
    private final BeanController beanController;

    // Konstruktorinjektion
    public BeanExampleApplication(BeanController beanController) {
        this.beanController = beanController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeanExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            log.debug(beanController.putMessage("Hello World"));
            log.debug(beanController.putMessage("--> OOOHOOO <--"));
        };
    }
}
