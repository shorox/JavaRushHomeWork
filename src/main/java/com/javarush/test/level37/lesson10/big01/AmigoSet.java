package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by sharov on 13.04.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        this.map = new HashMap<>((int) Math.max(16, collection.size()/.75f));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) != null;
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object clone(){
        AmigoSet<E> amigoSet = new AmigoSet<>();
        try {
            amigoSet.addAll(map.keySet());
            amigoSet.map.putAll(this.map);
        }catch (Exception e){
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();

        out.writeObject(map.size());
        for (E e : map.keySet()) {
            out.writeObject(e);
        }

        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();

        Set<E> set = new HashSet<>();
        int size = (int) in.readObject();
        for (int i = 0; i < size; i++) {
            set.add((E) in.readObject());
        }

        int capacity = (int) in.readObject();
        float loadFactor = (float) in.readObject();
        map = new HashMap<>(capacity, loadFactor);
        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
