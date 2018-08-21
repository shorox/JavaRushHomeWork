package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        for(Word word : list)
            System.out.println(word);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<Word>();
        for(String word : words){
            int N = crossword.length;
            for(int i = 0; i < N; i++) {
                int M = crossword[i].length;
                for (int j = 0; j < M; j++) {
                    Word w = null;
                    if ((w = objWord(crossword, word, M - j, M - j, i, j, '0', '+')) != null) list.add(w);
                    if ((w = objWord(crossword, word, M - j, N - i, i, j, '+', '+')) != null) list.add(w);
                    if ((w = objWord(crossword, word, N - i, N - i, i, j, '+', '0')) != null) list.add(w);
                    if ((w = objWord(crossword, word, N - i, j + 1, i, j, '+', '-')) != null) list.add(w);
                    if ((w = objWord(crossword, word, j + 1, j + 1, i, j, '0', '-')) != null) list.add(w);
                    if ((w = objWord(crossword, word, i + 1, j + 1, i, j, '-', '-')) != null) list.add(w);
                    if ((w = objWord(crossword, word, i + 1, i + 1, i, j, '-', '0')) != null) list.add(w);
                    if ((w = objWord(crossword, word, i + 1, M - j, i, j, '-', '+')) != null) list.add(w);
                }
            }
        }
        return list;
    }

    private static Word objWord(int[][] a, String word, int n1, int n2, int i , int j, char op_i, char op_j) {
        if(n1 >= word.length() && n2 >= word.length()) {
            char[] ch = word.toCharArray();
            int l = ch.length;
            for (int p = 0; p < l; p++)
                if (a[op_i == '-' ? i - p : op_i == '+' ? i + p : i][op_j == '-' ? j - p : op_j == '+' ? j + p : j] != ch[p])
                    return null;
            return new Word(word, j, i, op_j == '-' ? j - l + 1 : op_j == '+' ? j + l - 1 : j,
                    op_i == '-' ? i - l + 1 : op_i == '+' ? i + l - 1 : i);
        }
        return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public Word(String text, int i, int j, int k, int l) {
            this(text);
            this.setStartPoint(i, j);
            this.setEndPoint(k, l);
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}