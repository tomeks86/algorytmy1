package com.company.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordsMixer {
    public static ArrayList<String> mixWords(ArrayList<String> words) {
        Collections.shuffle(words);
        return words;
    }

    private static ArrayList<String> getWords(String line) {
        ArrayList<String> words = new ArrayList<>();
        for (String word : line.split("\\s+")) {
            words.add(word);
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me a names list:");
        ArrayList<String> names = getWords(sc.nextLine());
        names = mixWords(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
