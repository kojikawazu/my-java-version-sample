package com.example.versiondemo.internal.version;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version10")
public class Version10Controller {

	/**
     * Java 10: ローカル変数型推論（var）（JEP 286・正式機能）
     * 型を明示せずに変数宣言が可能（ただし読みやすさ重視で使い所を選ぶ）
     * @return String
     */
    @GetMapping("/var-example")
    public String varExample() {
        var message = "Hello from Java 10";
        var list = List.of("Java", "10", "var");

        return message + " / List size: " + list.size();
    }
}
