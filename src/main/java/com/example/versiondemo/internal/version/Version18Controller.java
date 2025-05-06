package com.example.versiondemo.internal.version;

import java.nio.charset.Charset;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version18")
public class Version18Controller {

	/**
	 * Java 18: UTF-8がデフォルトエンコーディングになったことを確認する
	 */
	@GetMapping("/charset")
	public String checkCharset() {
		Charset defaultCharset = Charset.defaultCharset();
		return "Default charset: " + defaultCharset.name(); // → "UTF-8"
	}
}
