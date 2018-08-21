package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if(n == null || getClass() != n.getClass()) return false;
        if(this == n) return true;
        Solution o = (Solution) n;
        if (first != null ? !first.equals(o.first) : o.first != null) return false;
        if (last != null ? !last.equals(o.last) : o.last != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (first != null ? 31 * first.hashCode() : 0) + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
