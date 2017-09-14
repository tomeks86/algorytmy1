package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort implements SortingAlgorithm {

    private void swap(int[] tab, int i, int j) {

        int tmp = tab[j];
        tab[j] = tab[i];
        tab[i] = tmp;
    }

    public int[] sorted(int[] unsorted) {

        int n = unsorted.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = unsorted[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j+1]) swap(sorted, j, j + 1);
            }
        }

        return sorted;
    }


    @Override
    public int sort(int[] table) {

        int n = table.length;
        int compNum = 0;

        if (n > 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    compNum += 1;
                    if (table[j] > table[j + 1]) swap(table, j, j + 1);
                }
            }
        }

        return compNum;
    }

    public int subSort(int[] table, int k, int compNum) {
        int n = table.length;
        //ArrayList<Integer> indices = new ArrayList<>();
        //for (int i = 0; i < n - k; i++) {
        for (int j = 0; j < n - k; j++) {
            compNum += 1;
            if (table[j] > table[j + k]) {
                swap(table, j, j + k);
            }
        }
        //}
        System.out.println(compNum);
        return compNum;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        int[] unsorted = {1, 6, -5, 6, 3, 6, 32, 65, -32};

        System.out.println(unsorted[0] + " " + unsorted[1]);
        bubbleSort.swap(unsorted, 0, 1);
        System.out.println(unsorted[0] + " " + unsorted[1]);

    }
}
