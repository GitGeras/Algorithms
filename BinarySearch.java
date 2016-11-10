package com.example.Algorithms.DivideAndRule;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Geras on 12.08.2016.
 */
public class BinarySearch {
    Scanner in;
    int[] array;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
//        System.out.println(finishTime - startTime + " ms");
    }

    private void run() {
        StringBuilder s = new StringBuilder();
        inputArray();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            s.append(search(in.nextInt()) + " ");
        }
        System.out.println(s);
    }

    private int search(int i) {
        int l = 0, r = array.length-1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (array[m] == i)
                return m + 1;
            else if (array[m] > i)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    private void inputArray() {
        in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
    }
}
