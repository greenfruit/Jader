package com.sjz.home;

import com.sjz.home.ListImpl.MyArrayList;
import org.junit.Test;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/3/9
 * <p>UPDATE DATE: 2017/3/9
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class MyArrayListTest {
    @Test
    public void test(){
        MyArrayList<Integer> newList = new MyArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.remove(0);
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
        for (Integer list: newList) {
            System.out.println("list item"+list);
        }
    }
}
