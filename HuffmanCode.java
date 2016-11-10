/*
package com.example.Algorithms.Huffman;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.*;
import java.util.*; // Для использования класса Stack

////////////////////////////////////////////////////////////////
class Node {
    public int iData; // Данные, используемые в качестве ключа
    public int dData = -1; // Другие данные
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла

    public Node(int iData, int dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public Node() {
    }
} // Конец класса Node

////////////////////////////////////////////////////////////////
class Tree {
    private Node root; // first node of tree

    // -------------------------------------------------------------
    public Tree(Node node) // Конструктор
    {
        root = node;
    } // Пока нет ни одного узла
    // -------------------------------------------------------------x

    public Tree(Tree t1, Tree t2) {
        root = new Node();
        root.leftChild = t1.root;
        root.rightChild = t2.root;
        root.iData = root.leftChild.iData + root.rightChild.iData;
    }

    public int getPriority() {
        return root.iData;
    }

    public String[] getCode(int length) {
        String[] codes = new String[length];
        Stack<Integer> stack = new Stack<>();
        //Если только один символ
        if (root.leftChild == null && root.rightChild == null) {
            codes[root.dData] = "0";
            return codes;
        }
        inOrder(root, stack, codes);
        return codes;
    }

    private void inOrder(Node node, Stack stack, String[] array) {
        if (node != null) {
            stack.push(0);
            inOrder(node.leftChild, stack, array);
            stack.pop();
            if (node.dData != -1) {
                StringBuilder s = new StringBuilder();
                for (Object o : stack) {
                    s.append((Integer) o);
                }
                array[node.dData] = s.toString();
            }
            stack.push(1);
            inOrder(node.rightChild, stack, array);
            stack.pop();
        }
    }

// -------------------------------------------------------------
} // Конец класса Tree
////////////////////////////////////////////////////////////////

public class HuffmanCode {
    char[] input;

    public static void main(String[] args) {
        new HuffmanCode().run();

    }

    private void run() {
        int[] array = inputArray();
        PriorityQueue<Tree> trees = getPQ(array);
        while (trees.size() != 1) {
            trees.add(new Tree(trees.poll(), trees.poll()));
        }
        String[] codes = trees.poll().getCode(array.length);
        int number = count(codes);
        String s = getMessage(codes);
        System.out.println(number + " " + s.length());
        for (int i = 0; i < codes.length; i++) {
            if (codes[i]!=null)
                System.out.println((char)('a' + i) + ": " + codes[i]);
        }
        System.out.println(s);
    }

    private String getMessage(String[] codes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            builder.append(codes[((int) input[i] - 'a')]);
        }
        return builder.toString();
    }

    private int count(String[] codes) {
        int number = 0;
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] == null)
                continue;
            number++;
        }
        return number;
    }

    //Преобразуем массив в упорядоченный набор деревьев, состоящих из одного узла
    private PriorityQueue<Tree> getPQ(int[] array) {
        PriorityQueue<Tree> trees = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return Integer.compare(o1.getPriority(), o2.getPriority());
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                trees.add(new Tree(new Node(array[i], i)));
            }
        }
        return trees;
    }

    //Преобразуем входящую строку в массив частот символов
    private int[] inputArray() {
        Scanner in = new Scanner(System.in);
        input = in.next().toCharArray();
        int[] array = new int[26];
        for (int i = 0; i < input.length; i++) {
            int code = input[i] - 'a';
            array[code]++;
        }
        return array;
    }
}
*/
