package com.collectionl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 作者：张鹏烨
 * 2025/8/22
 **/
public class hashset {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("jack");
        set.add("tom");
        set.add("john");
        set.add("curry");
        Iterator iterator =  set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
