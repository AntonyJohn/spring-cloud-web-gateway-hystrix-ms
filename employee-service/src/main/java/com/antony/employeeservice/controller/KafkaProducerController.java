package com.antony.employeeservice.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antony.employeeservice.Log;
import com.antony.employeeservice.dataobject.Email;
import com.antony.employeeservice.dataobject.Employee;
import com.antony.employeeservice.utill.Response;

/**
 * 
 * @author Antony John
 *
 */

@RestController
@RequestMapping("/kafka-producer")
public class KafkaProducerController {
	private static @Log Logger LOG;	
	
	@Autowired
    private MessageChannel output;
	
	
	@PostMapping(value="/email")
    @ResponseStatus(HttpStatus.OK)    
    public Email  sendEmail(@RequestBody Email email){					
    	LOG.info("Start:: KafkaProducerController --> sendEmail() - POST");     
    	output.send(MessageBuilder.withPayload(email).build());
    	LOG.info("End:: KafkaProducerController --> sendEmail() - POST");
        return email;    	                 	
    }
}
