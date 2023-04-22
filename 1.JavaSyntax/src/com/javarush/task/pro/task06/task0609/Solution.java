package com.javarush.task.pro.task06.task0609;

/* 
Кубический калькулятор в кубе
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static long cube(long i){
        return i*i*i;
    }

    public static long ninthDegree(long i){
        return cube(cube(i));
    }
}

