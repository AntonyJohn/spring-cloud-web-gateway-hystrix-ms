package com.antony.cloudapigateway;

import java.util.LinkedHashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antony.cloudapigateway.utill.Response;

//import reactor.core.publisher.Mono;

/**
 * 
 * @author Antony John
 *
 */
@RestController
public class FallbackController {

	//@GetMapping(value = "/accountFallBack", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/accountFallBack")
    //@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public Response orderServiceFallBack() {
        //return Mono.just("Account Service is taking too long to respond or is down. Please try again later");
        //return new ResponseEntity<String>("Account Service is taking too long to respond or is down. Please try again later",HttpStatus.NOT_FOUND);
    	Response response=new Response(); 
    	response.setResponseType("F");
		LinkedHashMap<String, String> errorMap = new LinkedHashMap<String, String>();
		errorMap.put("message", "Account Service is taking too long to respond or is down. Please try again later");
		response.setResponseValue(errorMap);
        return response;		  
    }
    
}
