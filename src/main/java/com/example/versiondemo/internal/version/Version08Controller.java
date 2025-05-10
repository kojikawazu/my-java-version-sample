package com.example.versiondemo.internal.version;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version08")
public class Version08Controller {

	 /**
     * Java 8: Stream + Lambda 式（正式機能）
     * @return String
     */
    @GetMapping("/stream")
    public String streamLambda() {
        List<String> names = List.of("Tanaka", "Sato", "Kawasaki", "Sasaki");

        List<String> filtered = names.stream()
                .filter(name -> name.contains("sa"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return "Filtered: " + filtered;
    }

    /**
     * Java 8: Optional（正式機能）
     * @return String
     */
    @GetMapping("/optional")
    public String optionalExample() {
        Optional<String> name = Optional.of("Java");
        return name.map(n -> "Hello, " + n).orElse("No name provided");
    }

    /**
     * Java 8: 新しい Date and Time API（java.time）
     * @return String
     */
    @GetMapping("/date-api")
    public String dateApiExample() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return "Today is " + today.format(formatter);
    }
}
