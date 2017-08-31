package com.blog.controllers;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController implements ErrorController{

    @RequestMapping("/error")
	public String showError() {
    	return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String correctLogin() {
		return "hello";
	}
}