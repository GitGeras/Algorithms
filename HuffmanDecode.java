package com.example.Algorithms.Huffman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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

    public Tree() {
    }

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

    public void getHuffmanTree(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                Queue<Character> chars = new LinkedList<>();
                for (int j = 0; j < array[i].length(); j++) {
                    chars.add(array[i].charAt(j));
                }
                addNote(chars, root, i);
            }
        }
    }

    //Рекурсивно добавляем узел в дерево по коду
    private void addNote(Queue<Character> chars, Node node, int i) {
        if (!chars.isEmpty()) {
            char ch = chars.poll();
            if (ch == '0') {
                if (node.leftChild == null) {
                    node.leftChild = new Node();
                }
                addNote(chars, node.leftChild, i);
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node();
                }
                addNote(chars, node.rightChild, i);
            }
        } else {
            node.dData = i;
        }
    }

    public String getDecode(String message, int inputLength) {
        StringBuilder s = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inputLength; i++) {
            queue.add(message.charAt(i));
        }
        while (!queue.isEmpty()) {
            s.append((char) (getChar(queue, root) + 'a'));
        }
        return s.toString();
    }

    private int getChar(Queue<Character> queue, Node node) {
        if (node.dData != -1) {
            if (node.equals(root))
                queue.poll();
            return node.dData;
        } else {
            char ch = queue.poll();
            if (ch == '0')
                return getChar(queue, node.leftChild);
            else
                return getChar(queue, node.rightChild);
        }
    }

// -------------------------------------------------------------
} // Конец класса Tree
////////////////////////////////////////////////////////////////

public class HuffmanDecode {
    char[] input;
    private int inputLength;
    BufferedReader in;
    private int numberLiter;

    public static void main(String[] args) throws IOException {
        new HuffmanDecode().run();

    }

    private void run() throws IOException {
        String[] array = inputArray();
        Tree tree = null;
        if (numberLiter==1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i]!= null) {
                    tree = new Tree(new Node(0,i));
                }
            }
        } else {
            tree = new Tree(new Node());
            tree.getHuffmanTree(array);
        }
        String result = tree.getDecode(getMessage(), inputLength);
        System.out.println(result);
    }

    private String getMessage() throws IOException {
        return in.readLine();
    }

    //Преобразуем входящую строку в массив частот символов
    private String[] inputArray() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        numberLiter = Integer.valueOf(s[0]);
        inputLength = Integer.valueOf(s[1]);
        String[] array = new String[26];
        for (int i = 0; i < numberLiter; i++) {
            s = in.readLine().split(": ");
            array[(int) (s[0].charAt(0) - 'a')] = s[1];
        }
        return array;
    }
}
