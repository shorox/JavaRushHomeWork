package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array == null || array.length < 2) return array;
        Arrays.sort(array);
        int len = array.length;
        final double mediana = len % 2 == 0 ? (array[len / 2 - 1] + array[len / 2]) / 2 : array[len / 2];
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
                return (int)(value == 0 ? o1 - o2 : value);
            }
        });
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {2, 5, 6, 7, 21, 1};
        sort(array);
        for(int a : array)System.out.print(String.format("%s ", a));
    }
}
