package com.example.versiondemo.internal.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarterController {

	@GetMapping("/")
	public String starter() {
		return "OK";
	}
}
