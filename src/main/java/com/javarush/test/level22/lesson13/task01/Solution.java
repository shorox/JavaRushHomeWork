package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] s = new String[tokenizer.countTokens()];
        for(int i = 0; i < s.length; i++) s[i] = tokenizer.nextToken();
        return s;
    }

    public static void main(String[] args){
        String[] s = getTokens("level22.lesson13.task01", ".");
        for(String p : s) System.out.println(p);
    }
}
