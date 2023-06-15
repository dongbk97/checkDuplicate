package org.example;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "A");
        stringMap.put(2, "B");
        stringMap.put(1, "C");
        stringMap.forEach((k, v) -> {
            System.out.println(k+"-"+v);
        });
    }
}
