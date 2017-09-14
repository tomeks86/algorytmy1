package com.company;

import java.util.Arrays;

public class BinarySearch implements SearchAlgorithm {

    @Override
    public int search(int[] T, int x) {

        int L = 0, c, P = T.length;
        if (T.length == 0) {
            System.out.println("empty table provided...");
            return -1;
        }

        P -= 1;

        while(L < P) {
            c = (L + P) / 2;
            if (T[c] < x) {
                L = c + 1;
            } else {
                P = c;
            }
        }

        if (T[L] == x) {
            return L;
        } else {
            System.out.println("element " + x + " not found!");
            return -1;
        }
    }

    public int search_alt(int[] T, int x) {

        int L = 0, c, P = T.length;
        if (T.length == 0) {
            System.out.println("empty table provided...");
            return -1;
        }

        P -= 1;

        while(L < P) {
            c = (L + P + 1) / 2;
            if (T[c] <= x) {
                L = c;
            } else {
                P = c - 1;
            }
        }

        if (T[L] == x) {
            return L;
        } else {
            System.out.println("element " + x + " not found!");
            return -1;
        }
    }

    public static void main(String[] args) {

        int size = 60;
        int[] exTable = new int[size];
        for (int i = 0; i < size; i++) {
            exTable[i] = i / 4;
        }

        //System.out.println(Arrays.toString(exTable));

        int[] exTable2 = {0, 1, 1, 2, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 9};

        BinarySearch binarySearch = new BinarySearch();

        int search = 3;
        int index = binarySearch.search(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);
        index = binarySearch.search_alt(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);
        //System.exit(0);
        /*if (index > -1) System.out.println(index + " " + exTable[index]);
        for(int i = 0; i < 20; i++) {
            index = binarySearch.search(exTable, i);
            if (index > -1) {
                System.out.println("element " + i + " found at index: " + index + " (check): " + exTable[index]);
            } else {
                System.out.println("element " + i + " not found...");
            }
        }*/
    }
}
