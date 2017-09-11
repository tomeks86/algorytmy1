package com.company;

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
        } else return -1;
    }

    @Override
    public int search2(int[] T, int x) {

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
        } else return -1;
    }

    public static void main(String[] args) {

        int size = 30;
        int[] exTable = new int[size];
        for (int i = 0; i < size; i++) {
            exTable[i] = i / 8;
        }

        int[] exTable2 = {0, 1, 1, 2, 5, 6, 7, 8, 8, 8, 9, 9, 9, 9, 9};

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(exTable, 5);
        int search = 3;
        int index = binarySearch.search(exTable2, search);
        System.out.println(index);
        //int index = binarySearch.search(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);
        else System.out.println("Element: " + search + " not found!");
        index = binarySearch.search2(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);
        else System.out.println("Element: " + search + " not found!");
        for(int i = 0; i < 20; i++) {
            index = binarySearch.search(exTable, i);
            if (index > -1) {
                System.out.println("element " + i + " found at index: " + index + " (check): " + exTable[index]);
            } else {
                System.out.println("element " + i + " not found...");
            }
        }
    }
}
