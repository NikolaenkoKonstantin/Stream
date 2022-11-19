package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            HashMap<String, Integer> result = new HashMap<>();

            Comparator<Map.Entry<String, Integer>> c1 = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
            Comparator<Map.Entry<String, Integer>> c2 = Comparator.comparing(Map.Entry::getKey);

            stream(in.readLine().split("\\s*(\\s|,|!|\\.|\\?)\\s*"))
                    .map(String::toLowerCase)
                    .forEach(w -> {
                        if (result.containsKey(w))
                            result.put(w, result.get(w) + 1);
                        else
                            result.put(w, 1);
                    });

            result.entrySet()
                    .stream()
                    .sorted(c1.thenComparing(c2))
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}