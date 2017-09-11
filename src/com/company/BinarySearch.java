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

    /*@Override
    public int searchDoublesReverted(int[] T, int x) {

        int L = 0, c, P = T.length;
        if (T.length == 0) {
            System.out.println("empty table provided...");
            return -1;
        }

        P -= 1;

        while(L < P) {
            c = (L + P + 1) / 2;
            if (T[c] > x) {
                P = c - 1;
            } else {
                L = c;
            }
        }

        if (T[L] == x) {
            return L;
        } else return -1;
    }*/


}
