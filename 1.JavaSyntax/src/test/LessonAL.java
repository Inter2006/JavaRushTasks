package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class LessonAL {
    public static void main(String[] args) {
        int[] array = new int[10];
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 35; i++) {
            list.add(random.nextInt(75));
        }
        System.out.println(list);
        if(list.contains(35)){
            System.out.println(list.indexOf(35));
        }else{
            System.out.println("Нет");
            Collections.sort(list);
            System.out.println(list);
        }

    }
}
