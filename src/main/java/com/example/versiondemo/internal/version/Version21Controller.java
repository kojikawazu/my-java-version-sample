package com.example.versiondemo.internal.version;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version21")
public class Version21Controller {

	/**
	 * Java 21: Pattern Matching for switch（正式機能）
	 * @return String
	 */
    @GetMapping("/pattern-switch")
    public String patternSwitch() {
        Object obj = 123;

        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s  -> "String: " + s;
            default        -> "Unknown type";
        };

        return result;
    }

    /**
     * Java 21: Record Pattern（正式機能）
     * @return String
     */
    record User(String name, int age) {}

    @GetMapping("/record-pattern")
    public String recordPattern() {
        Object obj = new User("Java21", 21);

        if (obj instanceof User(String name, int age)) {
            return "Name: " + name + ", Age: " + age;
        }
        return "Not a user";
    }

    /**
     * Java 21: Sequenced Collections（正式機能）
     * @return String
     */
    @GetMapping("/sequenced")
    public String sequencedCollection() {
        SequencedSet<String> set = new LinkedHashSet<>();
        set.add("first");
        set.add("middle");
        set.add("last");

        String first = set.getFirst(); // Java 21新メソッド
        String last = set.getLast();   // Java 21新メソッド

        return "First: " + first + ", Last: " + last;
    }
}
