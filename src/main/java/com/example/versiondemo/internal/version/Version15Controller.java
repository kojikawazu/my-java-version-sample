package com.example.versiondemo.internal.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version15")
public class Version15Controller {
	
	 /**
     * Java 15: Text Blocks（正式リリース）
     * 複数行の文字列を """ ～ """ で記述可能に
     */
	@GetMapping("/text-block")
    public String etxtBlocks() {
		String html = """
            <html>
              <body>
                <h1>Hello, Java 13 Text Blocks!</h1>
              </body>
            </html>
            """;
        
		return html;
    }
}
