package com.api.diversas.navcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Login {
	
	@GetMapping("/home/login")
	protected String login() {
		return "login.html";
	}


}
