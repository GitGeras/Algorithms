package com.example.Algorithms.Greed;

import java.util.*;

/**
 * Created by Geras on 08.08.2016.
 */
public class Greed3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (n!=0)
        {
            if (n-count==0 || n - count >= count+1)
            {
                n = n - count;
                list.add(count);
            }
            count++;
        }
        System.out.println(list.size());
        for (int i : list
                ) {
            System.out.print(i + " ");
        }

    }
}
