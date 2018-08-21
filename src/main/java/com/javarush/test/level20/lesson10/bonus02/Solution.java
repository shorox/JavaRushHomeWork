package com.javarush.test.level20.lesson10.bonus02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count);
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int N = a.length;
        byte[][] b = new byte[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                b[i][j] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(b[i][j] == 0 && a[i][j] == 1){
                    count++;
                    int horiz = j;
                    for(int m = j; m < N; horiz = m++) if(a[i][m] != 1) break;
                    int vert = i;
                    for(int n = i; n < N; vert = n++) if(a[n][j] != 1) break;
                    for(int m = i; m <= vert; m++)
                        for(int n = j; n <= horiz; n++)
                            b[m][n] = 1;
                    System.out.println("Прямоугольник №" + count + ", начальная точка [" + i + ", " + j + "], конечная точка [" + vert + ", " + horiz + "]");
                }
            }
        }
        return count;
    }
}
