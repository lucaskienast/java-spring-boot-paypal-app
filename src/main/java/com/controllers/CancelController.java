package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CancelController {

	@GetMapping(path="/cancel_payment")
	public String cancelPayment() {
		return "cancel";
	}
	
}