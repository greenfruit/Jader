package com.sjz.home.ListImpl;

import java.util.Iterator;

/**
 * <p>DESCRIPTION:  ArraList 独立实现
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/3/9
 * <p>UPDATE DATE: 2017/3/9
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class MyArrayList<T> implements Iterable<T>{

    private static final int INIT_CAPACITY_SIZE = 10;
    private int intSize;//记录当前数组大小
    private T[] items;//数组对象

    //构造函数
    public MyArrayList(){
        clear();
    }

    //清空数组元素，初始化数组空间
    private void clear() {
        items = null;
        ensureCapacity();
    }
    //size
    public int size(){
        return intSize;
    }

    //分配容器-泛型的界限类型
    private void ensureCapacity() {
        items = (T[]) new Object[INIT_CAPACITY_SIZE];
    }

    //动态分配容器
    private void reEnsureCapacity() {
        T[] old = items;
        T[] items = (T[]) new Object[INIT_CAPACITY_SIZE*2 + 1];
        for (int i = 0 ; i< size(); i++) {
            items[i] = old[i];
        }
    }
    //add元素
    public boolean add(T data){
        add(size(),data);
        return true;
    }
    //add元素
    public T get(int idx){
        if(idx<0||idx>= intSize){
            throw new ArrayIndexOutOfBoundsException("Index " + idx + "; size " + size());
        }
        return items[idx];
    }

    public void add(int idx, T x)
    {
        if(items.length == size())
            reEnsureCapacity();
        for (int i=intSize; i>idx; i--)
            items[i] = items[i-1];
        items[idx] = x;
        intSize++;
    }
    //remove
    public T remove(int idx){
        T removedItem = items[idx];
        for (int i=idx; i<size()-1; i++)
            items[i] = items[i+1];
        intSize--;
        return removedItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int current = 0;
        private boolean okToRemove = false;
        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new java.util.NoSuchElementException();
            okToRemove = true;
            return items[current++];
        }

        @Override
        public void remove() {
            if(!okToRemove)
                throw new IllegalStateException();
            MyArrayList.this.remove(--current);
            okToRemove = false;
        }
    }
}
