package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args){
        long t0 = new Date().getTime();
        long memoryStart = Runtime.getRuntime().freeMemory();
        int[] array = getNumbers(10000);
        long t1 = new Date().getTime();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        System.out.println("Time need to create the array = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (memoryStart - memoryEnd) / 1024);
        for(int a : array) System.out.print(a + " ");
    }

    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i < N; i++){
            int tmp = i;
            int count = 1;
            int rang = 10;
            while(tmp >= rang){ rang *= 10; count++; }
            int sum = 0;
            while(tmp > 0){
                byte b = (byte)(tmp % 10);
                int p = b;
                for(int j = 2; j <= count; j++) p *= b;
                sum += p;
                tmp = tmp / 10;
            }
            if(sum == i) list.add(i);
        }
        result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
