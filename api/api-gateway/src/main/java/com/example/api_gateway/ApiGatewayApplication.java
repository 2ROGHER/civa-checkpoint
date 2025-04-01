package com.example.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.logging.Logger;

@SpringBootApplication
public class ApiGatewayApplication {

    private static final Logger logger = Logger.getLogger(ApiGatewayApplication.class.toString());

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(ApiGatewayApplication.class, args);
        Environment env = context.getEnvironment();
        String PORT = env.getProperty("server.port");
        logger.info("Server running and listening on port [" + PORT + "]");
    }

}
