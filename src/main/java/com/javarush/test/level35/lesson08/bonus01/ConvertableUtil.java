package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap();
        for(V v : list)
            result.put((K) v.getKey(), v);
        return result;
    }
}
