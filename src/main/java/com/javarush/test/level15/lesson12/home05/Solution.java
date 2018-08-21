package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigInteger;

public class Solution {

    private Solution(Object o){}
    private Solution(int i){}
    private Solution(String s){}

    Solution(long l){}
    Solution(double d){}
    Solution(float f){}

    protected Solution(Integer i){}
    protected Solution(){}
    protected Solution(Number n){}

    public Solution(char ch){}
    public Solution(Double d){}
    public Solution(Float f){}
}

