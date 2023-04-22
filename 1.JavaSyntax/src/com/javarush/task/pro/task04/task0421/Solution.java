package com.javarush.task.pro.task04.task0421;

/* 
Охлаждение ядра планеты
*/

public class Solution {
    public static void main(String[] args) {
        int s = 0;
        int n = 1;
        while (n <= 100){
            if(n % 2 == 0){
                s += n;
            }n++;
        }System.out.println(s);
    }
}