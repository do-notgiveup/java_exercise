package vn.edu.likelion.basic_authentication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicAuthenticationApplication {
    private static final Logger logger = LogManager.getLogger(BasicAuthenticationApplication.class);

    public static void main(String[] args){
//        logger.info("This is an info message"); logger.error("This is an error message");

        logger.trace("Entering method processOrder().");
        logger.debug("Received order with ID 12345.");
        logger.info("Order shipped successfully.");
        logger.warn("Potential security vulnerability detected in user input: '...'");
        logger.error("Failed to process order. Error: {. . .}");
        logger.fatal("System crashed. Shutting down...");

        SpringApplication.run(BasicAuthenticationApplication.class, args);
    }

}
