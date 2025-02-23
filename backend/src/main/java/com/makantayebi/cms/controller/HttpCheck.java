package com.makantayebi.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HttpCheck {

    /**
     * just a smoke test, TODO: replace with actual testing in good time.
     * 
     * @return
     */
    @GetMapping
    public String health() {
        return "System is up.\n";
    }
}