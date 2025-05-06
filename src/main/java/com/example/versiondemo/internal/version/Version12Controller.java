package com.example.versiondemo.internal.version;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version12")
public class Version12Controller {
	
	/**
     * Java 12: Files.mismatch()
     * 2つのファイルを比較して最初に異なるバイト位置を返す
     */
	@GetMapping("file-mismatch")
	public String fileMismatch() {
		Path file1, file2;

		try {
			file1 = Files.writeString(Files.createTempFile("file1", ".txt"), "Hello World!");
			file2 = Files.writeString(Files.createTempFile("file2", ".txt"), "Hello Java!");

			long mismatch = Files.mismatch(file1, file2);
			if (mismatch == -1) {
			    System.out.println("Files are identical");
			    return "Files are identical";
			} else {
				System.out.println("Files differ at byte position: " + mismatch);
				return "Files differ at byte position: " + mismatch;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return "";
	}

	/**
     * Java 12: CompactNumberFormat
     * 数値を "1.2K" や "5M" 形式で表現する
     */
	@GetMapping("/compact-number-inst")
	public String compactNumberInst() {
		NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        nf.setMaximumFractionDigits(1);
        
        String result = nf.format(1_200) + ", " + nf.format(5_000_000);
        return "Formatted numbers: " + result; // → "Formatted numbers: 1.2K, 5M"
	}
}
