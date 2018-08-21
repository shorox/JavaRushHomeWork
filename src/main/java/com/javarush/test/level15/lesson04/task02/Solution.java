package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(2.0, 3, "8");
        printMatrix(2, 3.0, "8");
        printMatrix((Integer)2, 3, "8");
        printMatrix(2, (double)3, "8");
        printMatrix(2, (float)3, "8");
        printMatrix(new Double(2), 3, new ArrayList<Integer>());
        printMatrix((float)2, (Integer)3, "8");
        printMatrix(new Integer(2), new Double(3), "8");
        printMatrix(new Double(2), 3, new Object());
    }

    //1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    //2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    //3
    public static void printMatrix(Integer m, int n, String value) {
        System.out.println(m + " " + n + " " + value);
    }

    //4
    public static void printMatrix(double m, double n, Object value) {
        System.out.println(m + " " + n + " " + value);
    }

    //5
    public static void printMatrix(Double m, int n, List<Integer> value) {
        System.out.println(m + " " + n + " " + value);
    }

    //6
    public static void printMatrix(int m, Integer n, Object value) {
        System.out.println(m + " " + n + " " + value);
    }
    //7
    public static void printMatrix(float m, float n, Object value) {
        System.out.println(m + " " + n + " " + value);
    }

    //8
    public static void printMatrix(Integer m, Double n, Object value) {
        System.out.println(m + " " + n + " " + value);
    }

    //9
    public static void printMatrix(Integer m, int n, double value) {
        System.out.println(m + " " + n + " " + value);
    }

    //10
    public static void printMatrix(Integer m, Double n, int value) {
        System.out.println(m + " " + n + " " + value);
    }
}
