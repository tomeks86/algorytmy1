package com.company.shuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringBufferInputStream;
import java.util.*;

public class LetterCountCaseInsensitive {
    public static HashMap<Character, Integer> countLetters(String lines) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = (int) 'a'; i < ((int) 'z') + 1; i++) {
            result.put((char) i, 0);
        }
        for (int i = (int) '0'; i < ((int) '9') + 1; i++) {
            result.put((char) i, 0);
        }
        for (char c : lines.toLowerCase().toCharArray()) {
            try {
                result.put(c, result.get(c) + 1);
            } catch (NullPointerException e) {
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        String file = "file_small_zad_12.txt";
        String content = "";
        try {
            content = new Scanner(new File(file)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(content);
        /*System.out.println((int) 'a');
        System.out.println((int) 'z');*/
        /*System.out.println(((int) 'z' - (int) 'a'));
        System.out.println(((int) 'z' - (int) 'A'));
        System.out.println(((int) 'Z' - (int) 'A'));*/
        /*System.out.println((int) 'A');
        System.out.println((int) 'Z');*/
        long startTime = System.currentTimeMillis();
        HashMap<Character, Integer> counts = countLetters(content);
        SortedSet<Character> keys = new TreeSet<Character>(counts.keySet());
        for (Character character : keys) {
            System.out.printf("\"%c \": %d%n", character, counts.get(character));
        }
        long stopTime = System.currentTimeMillis();
        System.out.printf("File %s; the operation took %.2f seconds%n%n", file, (stopTime-startTime) / 1000.);

        file = "file_big_zad_12.txt";
        content = "";
        try {
            content = new Scanner(new File(file)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        counts = countLetters(content);
        keys = new TreeSet<Character>(counts.keySet());
        for (Character character : keys) {
            System.out.printf("\"%c \": %d%n", character, counts.get(character));
        }
        stopTime = System.currentTimeMillis();
        System.out.printf("File %s; the operation took %.2f seconds%n%n", file, (stopTime-startTime) / 1000.);

    }
}
