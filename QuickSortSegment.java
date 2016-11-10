package com.example.Algorithms.DivideAndRule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Geras on 22.08.2016.
 */
class Segment {
    public int a, b;

    @Override
    public String toString() {
        return String.valueOf(a) + " " + String.valueOf(b);
    }

    public Segment(int a, int b) {
        this.a = a;
        this.b = b;

    }
}

public class QuickSortSegment {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        new QuickSortSegment().run();
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms");
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            segments[i] = new Segment(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        for (int i = 0; i < n; i++) {
            System.out.println(segments[i]);
        }
    }
}
