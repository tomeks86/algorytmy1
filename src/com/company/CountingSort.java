package com.company;

import java.util.Arrays;

public class CountingSort {

    public int[] countingSort(int[] table) {

        int[] counts = new int[10];
        int[] sums = new int[10];
        int[] sorted = new int[table.length];

        for (int i = 0; i < table.length; i++) {
            counts[table[i]]++;
        }

        sums[0] = counts[0];
        for (int i = 1; i < 10; i++) {
            sums[i] = sums[i-1] + counts[i];
        }

        for (int i = table.length - 1; i > -1 ; i--) {
            sorted[sums[table[i]] - 1] = table[i];
            sums[table[i]]--;
            //System.out.println(table[i] + " " + (sums[table[i]] - 1));
        }

        return sorted;
    }

    public Person[] countingSort2(Person[] people) {
        int n = people.length;
        Person[] sorted = new Person[n];
        int[] counts = new int[10];
        int[] sums = new int[10];
        int vv, k;

        for (int i = 0; i < n; i++) {
            vv = people[i].v;
            counts[vv]++;
        }

        sums[0] = counts[0];
        for (int i = 1; i < 10; i++) {
            sums[i] = sums[i-1] + counts[i];
        }

       for (int i = n-1; i > -1; i--) {
            sorted[sums[people[i].v] - 1] = people[i];
            sums[people[i].v]--;
        }

        return sorted;
    }

    public static void main(String[] args) {

        CountingSort countingSort = new CountingSort();
        int size = 5;
        Person[] people = new Person[size];
        for (int i = 0; i < size; i++) {
            people[i] = new Person();
        }
        people[0].v = 2;
        people[0].name = "Franek";
        people[1].v = 3;
        people[1].name = "Henio";
        people[2].v = 2;
        people[2].name = "Josif";
        people[3].v = 1;
        people[3].name = "Xavier";
        people[4].v = 1;
        people[4].name = "Stefan";

        int[] numbers = {4, 3, 4, 2, 4, 7, 1, 6, 3, 5, 5, 2};
        int[] sorted = countingSort.countingSort(numbers);
        //System.out.println(Arrays.toString(sorted));

        people = countingSort.countingSort2(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].name + " " + people[i].v);
        }
    }

}
