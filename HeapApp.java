package com.example.Algorithms.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Geras on 10.08.2016.
 */
class Node {
    private int iData; // Данные (ключ)

    // -------------------------------------------------------------
    public Node(int key) // Конструктор
    {
        iData = key;
    }

    // -------------------------------------------------------------
    public int getKey() {
        return iData;
    }

    // -------------------------------------------------------------
    public void setKey(int id) {
        iData = id;
    }
// -------------------------------------------------------------
} // Конец класса Node

////////////////////////////////////////////////////////////////
class Heap {
    private Node[] heapArray;
    private int maxSize; // Размер массива
    private int currentSize; // Количество узлов в массиве

    // -------------------------------------------------------------
    public Heap(int mx) // Конструктор
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // Создание массива
    }

    // -------------------------------------------------------------
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // -------------------------------------------------------------
    public boolean insert(int key) {
        if (currentSize == maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    // -------------------------------------------------------------
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 &&
                heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent]; // Узел смещается вниз
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    // -------------------------------------------------------------
    public Node remove() // Удаление элемента с наибольшим ключом
    { // (Предполагается, что список не пуст)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    // -------------------------------------------------------------
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index]; // Сохранение корня
        while (index < currentSize / 2) // Пока у узла имеется
        { // хотя бы один потомок
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
// Определение большего потомка
            if (rightChild < currentSize && // (Правый потомок существует?)
                    heapArray[leftChild].getKey() <
                            heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
// top >= largerChild?
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;
// Потомок сдвигается вверх
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // Переход вниз
        }
        heapArray[index] = top; // index <- корень
    }

    // -------------------------------------------------------------
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getKey(); // Сохранение старого ключа
        heapArray[index].setKey(newValue); // Присваивание нового ключа
        if (oldValue < newValue) // Если узел повышается,
            trickleUp(index); // выполняется смещение вверх.
        else // Если узел понижается,
            trickleDown(index); // выполняется смещение вниз.
        return true;
    }

// -------------------------------------------------------------
} // Конец класса Heap

////////////////////////////////////////////////////////////////
class HeapApp {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    public static void main(String[] args) throws IOException {
        int n = getInt();
        Heap theHeap = new Heap(n); // Создание пирамиды с максимальным размером
        for (int i = 0; i < n; i++) {
            String s = getString();
            if (s.equals("ExtractMax")){
                System.out.println(theHeap.remove().getKey());
            }else {
                String[] res = s.split(" ");
                int i1 = Integer.valueOf(res[1]);
                theHeap.insert(i1);
            }
        }

    }

    //-------------------------------------------------------------
    public static String getString() throws IOException {
        String s = br.readLine();
        return s;
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
} // Конец класса HeapApp

////////////////////////////////////////////////////////////////