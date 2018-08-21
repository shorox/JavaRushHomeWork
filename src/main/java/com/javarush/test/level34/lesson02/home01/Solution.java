package com.javarush.test.level34.lesson02.home01;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement

        Locale.setDefault(Locale.ENGLISH);

        //PrintStream consoleStream = System.out;
        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //PrintStream stream = new PrintStream(outputStream);
        //System.setOut(stream);
        if(System.out.toString().length() == 0)
            System.setOut(new PrintStream(new ByteArrayOutputStream()));

        try {
            String temp = expression.replace(" ", "");
            int start;
            while ((start = temp.indexOf("(")) != -1) {
                int isEndBracket = 0;
                int i = start + 1;
                while (i < temp.length()){
                    if(temp.charAt(i) == ')' && isEndBracket == 0) break;
                    isEndBracket += (temp.charAt(i) == '(' ? 1 : (temp.charAt(i) == ')' ? (-1) : 0));
                    i++;
                }
                if (isEndBracket != 0 || start + 1 == i) throw new Exception();
                final String finalTemp = temp.substring(start + 1, i);
                System.out.println(0);
                recursion(finalTemp, countOperation);
                trigonom(new String[]{"sin", "cos", "tan"}, start, temp, finalTemp, countOperation);
            }
            //while((start = temp.indexOf("^")) != -1)
        } catch (Exception e) {
        }

        //String result = outputStream.toString();
        //System.setOut(consoleStream);
        //System.setOut(System.out);

    }

    private void trigonom(String[] name, int start, String expression, final String subExpression, int countOperation){
        for(int i = 0; i < name.length; i++) {
            if (expression.indexOf(name[i]) + name[i].length() == start) {
                countOperation++;
                try {
                    System.out.println(Math.class.getMethod(name[i], new Class[]{double.class}).invoke(Math.class, Double.parseDouble(System.out.toString())));
                    expression.replaceFirst(name + "(" + subExpression + ")", System.out.toString());
                    return;
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                }
            }
        }
        expression.replaceFirst("(" + subExpression + ")", System.out.toString());
    }

    public Solution() {
        //don't delete
    }
}
