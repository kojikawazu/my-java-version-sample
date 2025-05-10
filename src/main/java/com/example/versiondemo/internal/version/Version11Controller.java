package com.example.versiondemo.internal.version;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version11")
public class Version11Controller {

	/**
     * Java 11: HttpClient（JEP 321・正式機能）
     * 非同期・同期の両対応HTTPクライアント
     * @return String
     */
    @GetMapping("/http-client")
    public String httpClientExample() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            return "Status: " + response.statusCode();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Java 11: String API 拡張（isBlank, lines, repeat）
     * @return String
     */
    @GetMapping("/string-api")
    public String stringApiExample() {
        String text = "  \nLine1\nLine2\n";
        long lineCount = text.lines().count(); // → 3行

        String repeated = "Hi".repeat(3); // → HiHiHi
        boolean blank = text.isBlank();   // true（空白+改行のみ）

        return "Lines: " + lineCount + ", Repeated: " + repeated + ", IsBlank: " + blank;
    }
}
