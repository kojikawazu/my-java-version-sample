package com.example.versiondemo.internal.version;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version09")
public class Version09Controller {

    /**
     * Java 9: List.of, Set.of, Map.of（不変コレクションの簡易生成）
     * @return String
     */
    @GetMapping("/immutable-collections")
    public String immutableCollections() {
        List<String> list = List.of("Java", "9", "Collections");
        Map<String, Integer> map = Map.of("A", 1, "B", 2);

        return "List size: " + list.size() + ", Map keys: " + map.keySet();
    }

    /**
     * Java 9: Stream.takeWhile / dropWhile（条件付きストリーム制御）
     * @return String
     */
    @GetMapping("/stream-conditions")
    public String streamConditions() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 0, 6, 7);

        List<Integer> taken = numbers.stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList());

        List<Integer> dropped = numbers.stream()
                .dropWhile(n -> n < 5)
                .collect(Collectors.toList());

        return "TakeWhile: " + taken + ", DropWhile: " + dropped;
    }
}
