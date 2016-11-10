package com.example.Algorithms.Greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Geras on 08.08.2016.
 */
public class Greed1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Segment> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Segment(in.nextInt(), in.nextInt()));
        }
        Collections.sort(segments);
        ArrayList<Integer> result = new ArrayList<>();
        while (!segments.isEmpty()) {
            result.add(segments.get(0).r);
            while (!segments.isEmpty() && result.get(result.size() - 1) >= segments.get(0).l && result.get(result.size() - 1) <= segments.get(0).r) {
                segments.remove(0);
            }
        }
        System.out.println(result.size());
        for (int i :result
                ) {
            System.out.print(i + " ");
        }

    }

    private static class Segment implements Comparable<Segment> {
        int l, r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Segment s) {
            return (this.r - s.r);
        }
    }
}
