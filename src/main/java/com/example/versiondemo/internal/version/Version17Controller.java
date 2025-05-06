package com.example.versiondemo.internal.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version17")
public class Version17Controller {
	
	/**
     * Java 17: switch式（正式化）
     */
    @GetMapping("/switch")
    public String switcher() {
        String day = "one";

        int num = switch (day) {
            case "one" -> 1;
            case "two" -> 2;
            default -> 0;
        };
        
        return String.valueOf(num);
    }

    /**
     * Java 17: sealed class（正式化）
     */
    sealed interface Shape permits Circle, Rectangle {}

    record Circle(double radius) implements Shape {}
    record Rectangle(double width, double height) implements Shape {}

    @GetMapping("/sealed")
    public String useSealed() {
        Shape shape = new Circle(5.0);

        double area = switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
        };

        return "Area: " + area;
    }
}
