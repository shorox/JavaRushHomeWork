package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file = r.readLine();
        r.close();

        BufferedReader f = new BufferedReader(new FileReader(file));
        String str = "";
        while(f.ready()) str += f.readLine();
        f.close();

        List<String> list = new ArrayList<String>();
        String line = "";
        for (char c : str.toCharArray()){
            if(line.length() > 0) {
                if (String.valueOf(c).equals("<")){
                    list.add(line);
                    line = "<";
                }else if(String.valueOf(c).equals(">")){
                    list.add(line + ">");
                    line = "";
                }else line += String.valueOf(c);
            }else line = String.valueOf(c);
        }

        String srch = args[0];
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i).length() > srch.length() && list.get(i).substring(0, srch.length() + 1).equals("<" + srch)) {
                String p = list.get(i);
                int step = 0;
                for (int j = i + 1; j < list.size(); j++) {
                    p += list.get(j);
                    if(list.get(j).substring(0, 2).equals("</") && step == 0) break;
                    else if(list.get(j).substring(0, 2).equals("</") && step > 0) step--;
                    else if(list.get(j).substring(0, 1).equals("<")) step++;
                }
                System.out.println(p);
            }
        }
    }
}
