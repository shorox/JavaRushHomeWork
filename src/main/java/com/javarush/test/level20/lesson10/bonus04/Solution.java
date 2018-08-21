package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/


public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable{
    transient Node root = new Node(null, null);
    transient Node parent = root;
    transient int size = 0;

    private static final long serialVersionUID = 876323262645176254L;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++)
        {
            list.add(String.valueOf(i));
        }
        ((Solution) list).print();
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        System.out.println("list.remove(\"9\") " + list.remove("9"));
        System.out.println("list.remove(\"51\") " + list.remove("51"));
        ((Solution) list).print();
        System.out.println("list.add(\"16\") " + list.add("16"));
        System.out.println("list.add(\"17\") " + list.add("17"));
        System.out.println("list.add(\"18\") " + list.add("18"));
        System.out.println("list.add(\"19\") " + list.add("19"));
        System.out.println("list.add(\"20\") " + list.add("20"));
        ((Solution) list).print();
        System.out.println("list.remove(\"18\") " + list.remove("18"));
        System.out.println("list.remove(\"20\") " + list.remove("20"));
        ((Solution) list).print();
        System.out.println("list.add(\"21\") " + list.add("21"));
        System.out.println("list.add(\"22\") " + list.add("22"));
        ((Solution) list).print();
        System.out.println("list.clear()");
        list.clear();
        ((Solution) list).print();
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        ((Solution) list).print();
        System.out.println("list.remove(null) " + list.remove(null));
        System.out.println("list.remove(null) " + list.remove(null));
        ((Solution) list).print();
        System.out.println("list.add(\"a\") " + list.add("a"));
        System.out.println("list.add(\"b\") " + list.add("b"));
        System.out.println("list.add(\"c\") " + list.add("c"));
        System.out.println("list.add(\"d\") " + list.add("d"));
        System.out.println("list.add(\"e\") " + list.add("e"));
        ((Solution) list).print();
        System.out.println("list.remove(\"a\") " + list.remove("a"));
        System.out.println("list.remove(\"b\") " + list.remove("b"));
        ((Solution) list).print();
        for (int i = 1; i < 16; i++)
        {
            System.out.println("list.add(\"" + i + "\") " + list.add(String.valueOf(i)));
        }
        ((Solution) list).print();
        System.out.println("Parent 3 <- 1 = " + ((Solution) list).getParent("3"));
        System.out.println("Parent 5 <- 2 = " + ((Solution) list).getParent("5"));
        System.out.println("Parent 7 <- 3 = " + ((Solution) list).getParent("7"));
        System.out.println("Parent 10 <- 4 = " + ((Solution) list).getParent("10"));
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        ((Solution) list).print();
        System.out.println("Parent null <- 11 = " + ((Solution) list).getParent("11"));
        System.out.println("Parent null <- null = " + ((Solution) list).getParent(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("Parent 7 <- null = " + ((Solution) list).getParent(null));
        ((Solution) list).print();
        System.out.println("Size = 9 = " + list.size());
        System.out.print("\nSave list");
        FileOutputStream fos = new FileOutputStream("output.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("output.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" done\n");
        ((Solution) list2).print();
        System.out.println("list.iterator()");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        iterator = list.iterator();
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.remove() ");
        iterator.remove();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        ((Solution) list).print();
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println("\nlist.listIterator() while .hasNext() .next()");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) System.out.print(listIterator.next() + " ");
        System.out.println("\nwhile .hasPrevious() .previous()");
        while (listIterator.hasPrevious()) System.out.print(listIterator.previous() + " ");
        System.out.println("\nlistIterator.set(\"0\")");
        listIterator.set("0");
        ((Solution) list).print();
        System.out.println("listIterator.add(\"16\")");
        listIterator.add("16");
        ((Solution) list).print();
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.remove()");
        listIterator.remove();
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        ((Solution) list).print();
        listIterator = list.listIterator(1);
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.next() " + listIterator.next());


        /*List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));*/
    }

    public void print()
    {

        System.out.println(Arrays.toString(this.toArray()));
    }


    public Solution() {
    }

    public Solution(Collection<? extends String> c) {
        this();
        addAll(c);
    }

    private List<Node> getListNodes() {
        Queue<Node> list = new LinkedList<>();
        List<Node> result = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            Node node = list.remove();
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            result.add(node);
        }
        return result;
    }

    public String getParent(String value) {
        //have to be implemented
        List<Node> list = getListNodes();
        for(Node node : list)
            if(node.parent != null && node.item.equals(value))
                return node.parent.item;
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        List<Node> list = getListNodes();
        String[] result = new String[size];
        int i = 0;
        for(Node node : list)
            if(node.item != null) result[i++] = node.item;
        return result;
    }

    @Override
    public boolean add(String s) {
        if(s == null) return false;
        if(parent.right != null) {
            List<Node> list = getListNodes();
            for (Node node : list)
                if (node.left == null && node.right == null) {
                    parent = node;
                    break;
                }
        }
        Node newNode = new Node(s, parent);
        if (parent.left == null) parent.left = newNode;
        else parent.right = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        List<Node> list = getListNodes();
        for(Node node : list)
            if(node.item != null && node.item.equals(o)){
                if(node.left != null) remove(node.left.item);
                if(node.right != null) remove(node.right.item);
                if(node.parent.right != null && o.equals(node.parent.right.item)) node.parent.right = null;
                else node.parent.left = null;
                node.item = null;
                size--;
                return true;
            }
        return false;
    }

    @Override
    public void clear() {
        //remove(null);
        root = new Node(null, null);
        parent = root;
        size = 0;
        modCount++;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class Itr implements Iterator<String> {

        int cursor = 0;

        int lastRet = -1;

        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public String next() {
            checkForComodification();
            try {
                int i = cursor;
                String next = getListNodes().get(i).item;
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Solution.this.remove(getListNodes().get(lastRet));
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        List<Node> list = getListNodes();
        for(Node node : list)
            if(node.item.equals(o)) return true;
        return false;
    }

    @Override
    public String toString() {
        List<Node> list = getListNodes();
        String s = "";
        for(Node node : list)
            if(node.item != null)
                s += "(" + node.parent.item + ")" + node.item + "\n";
        return s;
    }

    public Object clone() {
        Solution sol = new Solution();
        sol.clear();
        Iterator<String> it = iterator();
        sol.root=new Node(null,null);
        while (it.hasNext())
            sol.add(it.next());
        return sol;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        List<Node> list = getListNodes();
        s.defaultWriteObject();
        s.writeInt(size);
        for (Node node : list)
            s.writeObject(node.item);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        for (int i = 0; i < size; i++)
            add((String) s.readObject());
    }

    private static class Node {
        String item;
        Node parent;
        Node left;
        Node right;

        Node(String element, Node parent) {
            this.item = element;
            this.parent = parent;
        }
    }
}
