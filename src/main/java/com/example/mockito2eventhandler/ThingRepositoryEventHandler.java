package com.example.mockito2eventhandler;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@RepositoryEventHandler
@Component
@Slf4j
public class ThingRepositoryEventHandler {

    @HandleAfterCreate
    public void doAfterCreate(Thing thing) {
        log.info("doAfterCreate {}", thing);
    }
}
