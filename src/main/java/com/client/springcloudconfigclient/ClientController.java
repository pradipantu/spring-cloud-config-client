package com.client.springcloudconfigclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
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
}
