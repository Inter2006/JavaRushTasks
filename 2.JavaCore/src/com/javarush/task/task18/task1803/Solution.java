package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Path.of(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        HashMap<Byte, Integer> map = IntStream.range(0, bytes.length).boxed()
                .collect(Collectors.toMap(index -> bytes[index], index -> 1, Integer::sum, HashMap::new));
        map.entrySet().stream()
                .filter(entry-> Objects.equals(entry.getValue(),map.values().stream().max(Integer::compareTo).orElseThrow()))
                .forEach(entry-> System.out.print(entry.getKey() + " "));
    }
    public static void main1(String[] args) throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        try (FileInputStream input = new FileInputStream(fileName)) {
            while (input.available() > 0){
                int aByte = input.read();
                if (!map.containsKey(aByte)){
                    map.put(aByte,1);

                }else {
                    map.put(aByte,map.get(aByte) + 1);
                }

            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            if(value > max) max = value;

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
