package com.example.versiondemo.internal.version;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version24")
public class Version24Controller {

	 /**
     * Java 24: Stream Gatherers（JEP 485・正式機能）
     * カスタム中間操作（バッチ化など）を定義可能なStreamの拡張機能
     * @return String
     */
    @GetMapping("/gatherer")
    public String gathererExample() {
        // 例：要素を2つずつまとめて処理する Gatherer
        Gatherer<String, ?, String> pairGatherer = Gatherer.ofSequential(
            () -> new StringBuilder[1],
            (holder, item, downstream) -> {
                if (holder[0] == null) {
                    holder[0] = new StringBuilder(item);
                    return true;
                } else {
                    holder[0].append("-").append(item);
                    downstream.push(holder[0].toString());
                    holder[0] = null;
                    return true;
                }
            },
            (holder, downstream) -> {
                if (holder[0] != null) {
                    downstream.push(holder[0].toString());
                }
            }
        );

        List<String> result = Stream.of("A", "B", "C", "D", "E")
            .gather(pairGatherer)
            .collect(Collectors.toList());

        return "Gathered: " + result;
    }
}
