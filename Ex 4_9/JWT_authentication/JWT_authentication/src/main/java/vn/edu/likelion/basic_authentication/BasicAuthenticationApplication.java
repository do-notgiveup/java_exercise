package vn.edu.likelion.basic_authentication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicAuthenticationApplication {
    private static final Logger logger = LogManager.getLogger(BasicAuthenticationApplication.class);

    public static void main(String[] args){
        logger.info("This is an info message"); logger.error("This is an error message");
        SpringApplication.run(BasicAuthenticationApplication.class, args);
    }

}
