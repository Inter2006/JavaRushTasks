package com.javarush.task.pro.task04.task0407;

/* 
Сумма чисел, не кратных 3
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int s = 0;
        int number = 0;
        while(number <= 100){
            if(number % 3 == 0){
                number++;
                continue;
            } s = s + number;
            number++;
        }
       System.out.println(s);
    }

}