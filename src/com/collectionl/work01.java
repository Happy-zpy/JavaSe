package com.collectionl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 作者：张鹏烨
 * 2025/8/20
 **/
public class work01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("kk");
        list.add("jj");
        list.add("zz");
        list.add(11);
        list.add(44);
        list.add("lll");
        list.add("kkkk");
        list.add("llll");
        list.add("pppppp");
        list.add(44);
        list.add(44);
        list.add(44);
        list.add(2,"hansunping");
        Object o = list.get(5);
        list.remove(7);
        list.set(6,"lokkk");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
