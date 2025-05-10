package com.example.versiondemo.internal.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version23")
public class Version23Controller {

	/**
     * Java 23: Unnamed Patterns and Variables（JEP 456・正式機能）
     * @return String
     */
    @GetMapping("/underscore-pattern")
    public String underscorePattern() {
        Object obj = 42;

        String result = switch (obj) {
            case String s -> "String: " + s;
            case Integer _ -> "Integer matched but not used";
            default -> "Unknown type";
        };

        return result;
    }
}
