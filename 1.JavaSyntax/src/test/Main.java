package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String string = reader.readLine();
                System.out.println(string);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
