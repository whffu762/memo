package net.dsa.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/ex/comment")
	public String comment() {
		return "ex/comment";
	}

}
