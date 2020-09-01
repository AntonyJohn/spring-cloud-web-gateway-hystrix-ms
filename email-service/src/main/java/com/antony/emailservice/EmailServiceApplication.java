package com.antony.emailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EmailServiceApplication {

	private Logger logger = LoggerFactory.getLogger(EmailServiceApplication.class);

    @StreamListener("input")
    public void consumeMessage(Email email) {
        logger.info("Consume email : " + email);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
