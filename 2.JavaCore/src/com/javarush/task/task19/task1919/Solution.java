package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Path.of(args[0])).stream()
                .collect(Collectors.toMap(
                        string -> string.split(" ")[0],
                        string -> Double.parseDouble(string.split(" ")[1]),
                        Double::sum,
                        TreeMap::new)).forEach((k, v) -> System.out.println(k + " " + v));

    }

    public static void main1(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String[] strings = string.split(" ");
                String name = strings[0];
                Double value = Double.parseDouble(strings[1]);
                if (!map.containsKey(name)) {
                    map.put(name, value);
                } else {
                    map.put(name, map.get(name) + value);
                }
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
