package com.company;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public int sort(int[] table) {
        int compNum = 0;
        int n = table.length, tmp;
        for (int i = 1; i < n; i++) {
            //tmp = table[i];
            //for (int j = i - 1; j >= 0 ; j--) {
            //    if (table[j] > tmp) {
            //        table[j+1] = table[j];
            //    } else break;
            //    table[j] = tmp;
            //}
            //while version doesn't have to put tmp to table[j] at every step :)
            tmp = table[i];
            int j = i - 1;
            while(j >= 0) {
                compNum++;
                if (table[j] > tmp) {
                    table[j + 1] = table[j];
                } else break;
                j -= 1;
            }
            table[j+1] = tmp;
        }
        return compNum;
    }

}
