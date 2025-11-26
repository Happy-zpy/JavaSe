package com.collectionl;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张鹏烨
 **/
public class arraylist {
    public static void main(String[] args) {
        List arraylist = new ArrayList();
        List list = new ArrayList();
        list.add("kk");
        list.add("jj");
        arraylist.add("jack");
        arraylist.add(12);
        arraylist.add("zpy");
        System.out.println(arraylist);
        arraylist.remove(Integer.valueOf(12));
        arraylist.remove("g");
        System.out.println(arraylist);
        boolean b = arraylist.contains("jack");//查找是否存在某个元素
        System.out.println(b);
        arraylist.size();//返回多少元素
        arraylist.isEmpty();//是否为空
        //arraylist.clear();//清空
        arraylist.addAll(list);//添加一个集合





    }
}
