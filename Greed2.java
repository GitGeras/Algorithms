package com.example.Algorithms.Greed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Geras on 08.08.2016.
 */
public class Greed2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            things.add(new Thing(in.nextInt(), in.nextInt()));
        }
        Collections.sort(things);
        int resultSize = 0;
        double resultCost = 0;
        while (resultSize != w) {
            Thing t = null;
            try {
                t = things.get(0);
            } catch (Exception e) {
                //Если больше нет вещей
                break;
            }
            things.remove(0);
            if (resultSize + t.size <= w) {
                resultSize += t.size;
                resultCost += t.cost;
            } else {
                resultCost += (double) (w - resultSize) / t.size * t.cost;
                resultSize = w;
            }
        }
        System.out.printf(Locale.US, "%.3f", resultCost);

    }

    private static class Thing implements Comparable<Thing> {
        int cost, size;

        public Thing(int c, int s) {
            this.cost = c;
            this.size = s;
        }

        @Override
        public int compareTo(Thing thing) {
            if ((double) this.cost / this.size - (double) thing.cost / thing.size > 0)
                return -1;
            else if ((double) this.cost / this.size == (double) thing.cost / thing.size)
                return 0;
            else
                return 1;
        }
    }
}
