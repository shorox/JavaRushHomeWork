package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        String s = "";
        for(Map.Entry<String, String> pair : params.entrySet())
            s += pair.getValue() != null ? (s.length() != 0 ? " and " : "") +
                    String.format("%s = '%s'", pair.getKey(), pair.getValue()) : "";
        return new StringBuilder(s);
    }
}
