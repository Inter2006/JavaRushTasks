package com.javarush.task.pro.task03.task0314;

import java.util.Scanner;

/* 
Сломанная клавиатура
*/

public class Solution {
    public static String secret = "AmIGo";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        if(secret.equalsIgnoreCase(string1)){
            System.out.println("доступ разрешен");//напишите тут ваш код
        }else {
            System.out.println("доступ запрещен");
        }

    }
}
