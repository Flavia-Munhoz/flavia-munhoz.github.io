package com.api.diversas.navcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	
	@GetMapping("/home")
	protected String promocao() {
		return "home.html";
	}

}
