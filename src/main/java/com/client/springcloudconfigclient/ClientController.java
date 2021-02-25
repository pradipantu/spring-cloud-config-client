package com.client.springcloudconfigclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {

    Logger logger= LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ExternalServerProperties externalServerProperties;

    @GetMapping(path="/")
    public String getDetails(){
        logger.info("External Properties :{}",externalServerProperties);
        return externalServerProperties.toString();
    }

    @PostMapping(path="/post",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> postDetails(@RequestBody String data){
        logger.info("Received request :{}",data);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }


}
