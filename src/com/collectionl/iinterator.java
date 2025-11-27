package com.collectionl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 作者：张鹏烨
 * 2025/8/19
 **/
@SuppressWarnings({"all"})
public class iinterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("kk");
        list.add("jj");
        list.add("zz");
        list.add(11);
        list.add(44);
        list.remove(Integer.valueOf(11));
        System.out.println(list);
        Iterator i = list.iterator();
        while (i.hasNext()){
            Object o = i.next();
            System.out.println(o);

        }

    }
    public void fun(){
        System.out.println("ngjgbnuidfhuighiuh");
    }
}