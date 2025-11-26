package com.collectionl;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张鹏烨
 **/
@SuppressWarnings({"all"})
public class collection {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("kk");
        list.add("jj");
        list.add("zz");
        list.add(11);
        list.add(44);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));}
        list.add(3,"4444");//在index的位置上插入元素addAll同理
        System.out.println(list.indexOf("kk"));
        list.remove(0);//删除index位置上的元素
        list.set(0,"张鹏烨");//替换index位置上的元素
        System.out.println(list.subList(0,2));//前闭后开

    }
}
