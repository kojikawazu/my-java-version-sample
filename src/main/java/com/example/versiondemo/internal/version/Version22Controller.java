package com.example.versiondemo.internal.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version22")
public class Version22Controller {

	/**
     * Java 22: None
     */
	@GetMapping
    public String none() {
		return "正式リリース機能はありません。";
    }
}
