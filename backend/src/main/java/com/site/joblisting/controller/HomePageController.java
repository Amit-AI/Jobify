package com.site.joblisting.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomePageController {

    @GetMapping("/")
    public String showHomePage(HttpServletRequest servletRequest) {
        log.debug("Inside HomePageController..");

        //TEST

        return "Welcome to JobListing";
    }
}
