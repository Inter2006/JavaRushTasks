package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();

        System.out.println(grades);

    }

    public static void addStudents() {
        grades.put("Филипп Игнатьев", 2.0);
        grades.put("Мария Астафьева", 4.5);
        grades.put("Игорь Крылов", 5.0);
        grades.put("Иван Петров", 3.85);
        grades.put("Василий Сидоров", 3.97);
    }
}
