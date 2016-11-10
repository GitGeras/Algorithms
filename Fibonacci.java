package com.example.Algorithms;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Geras on 04.08.2016.
 */

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();
        int m = in.nextInt();
        System.out.println(getRest(n, m));
    }


    private static int getRest(Long n, int m) {
        int[] array = new int[6 * m];
        array[0] = 0;
        array[1] = 1;
        int cicle = 1;
        for (int i = 2; i < 6 * m; i++) {
            array[i] = (array[i - 2] + array[i - 1]) % m;
            if (array[i - 1] == 0 && array[i] == 1) {
                cicle = i - 1;
                break;
            }
        }
        return array[(int) (n % cicle)];
    }


    private static int getLastNumber(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 10;
        }
        return array[n];
    }

    private static int getNumber(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

}
