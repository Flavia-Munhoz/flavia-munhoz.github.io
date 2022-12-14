package com.api.diversas.navcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DiversasFormas {

	
	@GetMapping("/home/diversasformasdeaprender")
	protected String diversasformas() {
		return "diversasformasdeaprender.html";
	}

}
