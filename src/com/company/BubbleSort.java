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

    public int[] countingSort(int[] table) {

        int[] counts = new int[10];
        int[] sums = new int[10];
        int[] sorted = new int[table.length];

        System.out.println(Arrays.toString(table));

        for (int i = 0; i < table.length; i++) {
            counts[table[i]]++;
        }

        sums[0] = counts[0];
        for (int i = 1; i < 10; i++) {
            sums[i] = sums[i-1] + counts[i];
        }

        //for (int i = 0; i < 10; i++) {
        //    System.out.println(i + " " + counts[i] + " " + sums[i]);
        //}

        System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(sums));

        for (int i = table.length - 1; i > -1 ; i--) {
            sorted[sums[table[i]] - 1] = table[i];
            sums[table[i]]--;
            System.out.println(table[i] + " " + (sums[table[i]] - 1));
        }

        return sorted;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        /*int[] unsorted = {1, 6, -5, 6, 3, 6, 32, 65, -32};

        System.out.println(unsorted[0] + " " + unsorted[1]);
        bubbleSort.swap(unsorted, 0, 1);
        System.out.println(unsorted[0] + " " + unsorted[1]);*/

        int size = 30;
        Person[] people = new Person[size];
        for (int i = 0; i < size; i++) {
            people[i] = new Person();
        }
        people[0].v = 2;
        people[0].name = "Franek";
        people[1].v = 1;
        people[1].name = "Franek";
        people[2].v = 2;
        people[2].name = "Josif";
        people[3].v = 1;
        people[3].name = "Xavier";

        int[] numbers = {4, 3, 4, 2, 4, 7, 1, 6, 3, 5, 5, 2};
        int[] sorted = bubbleSort.countingSort(numbers);
        System.out.println(Arrays.toString(sorted));

    }
}
