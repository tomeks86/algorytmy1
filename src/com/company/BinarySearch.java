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

    public static int values_between(int[] T, int i, int j) {
        if (i >= j) {
            System.out.println("first argument has to be smaller than the second");
            return -1;
        } else {
            BinarySearch binarySearch = new BinarySearch();
            int L = binarySearch.search(T, i);
            int R = binarySearch.search_alt(T, j);
            return R - L + 1;
        }
    }

    public int search_abc(int[] T) {
        int n = T.length;

        if (n < 3) {
            System.out.println("table too short, minimum table to run this algorithm is 3");
            return -1;
        } else {
            int L = 0, P = n-1, c = (L + P) / 2;
            while ((P - L) > 4) {
                c = (L + P) / 2;
                if ((T[c - 1] + T[c] + T[c + 1]) > 0) {
                    P = c + 1;
                } else if ((T[c - 1] + T[c] + T[c + 1]) < 0) {
                    L = c - 1;
                } else {
                    break;
                }
            }
            if ((P - L) == 4) {
                if ((T[L] + T[L + 1] + T[L + 2]) == 0) {
                    return L + 1;
                } else if ((T[L + 1] + T[L + 2] + T[L + 3]) == 0) {
                    return L + 2;
                }
            }
            if ((T[c - 1] + T[c] + T[c + 1]) == 0) {
                return c;
            } else return -1;
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

        System.out.println(values_between(exTable2,1,5));

        BinarySearch binarySearch = new BinarySearch();

        int search = 3;
        int index = binarySearch.search(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);
        index = binarySearch.search_alt(exTable, search);
        if (index > -1) System.out.println(index + " " + exTable[index]);

        System.out.println();
        int[] exTable3 = {-5,-4,-4,-4,-3,-3,1,2,2,6,8};

        index = binarySearch.search_abc(exTable3);
        if (index > -1) {
            System.out.println("special triple found at indices: " + (index - 1) + " " + index + " " + (index + 1));
            System.out.println("the sequence is: " + exTable3[index - 1] + " " + exTable3[index] + " " + exTable3[index + 1]);
        } else System.out.println("special triple not found!");

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
