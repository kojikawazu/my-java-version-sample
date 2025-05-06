package com.example.versiondemo.internal.version;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version16")
public class Version16Controller {
	
	 /**
     * Java 16: Record クラス（正式機能）
     */
	record User(String name, int age) {}
	
	@GetMapping("/record")
	public User printRecord() {
	    // record を使ってデータを返す
	    return new User("Java16", 16);
	}
	
	/**
     * Java 16: instanceof パターンマッチング（正式機能）
     */
	@GetMapping("/instanceof")
	public String instanceOfExample() {
		Object obj = "Hello Java 16";

		if (obj instanceof String s) {
			return "Length: " + s.length();
		}
		return "Not a string";
	}

	/**
     * Java 16: Stream.toList()（正式機能）
     */
	@GetMapping("/stream-to-list")
	public List<String> streamToListExample() {
		return Stream.of("Java", "16", "Stream").toList();
	}
}
