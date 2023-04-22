package com.javarush.task.pro.task05.task0512;

/* 
Создаем мультимассив
*/

public class Solution {

    public static int[][][] multiArray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1}, {2}, {3}, {4, 5}}};

    public static void main(String[] args) {
        for (int i = 0; i < multiArray.length; i++) {
            for (int n= 0; n < multiArray[i].length; n++) {
                for (int l = 0; l < multiArray[i][n].length; l++) {
                    System.out.print(multiArray[i][n][l] + " ");
                }
                System.out.println();
            }
            System.out.println("----------");
        }//напишите тут ваш код
    }
}
