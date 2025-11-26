package com.collectionl;

import java.util.*;

/**
 * 作者：张鹏烨
 * 2025/8/31
 **/
@SuppressWarnings({"all"})
public class map {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jjj","jin");
        map.put("张鹏烨","11.11");
        map.put("张志成","zz");
        map.put("jjj","kkkk");
        map.put("oir","ijjjjj");
        map.put("mmm","mmmmm");//相同的k时替换机制
        System.out.println(map);
        //remove删除 get size isempty,clear,containkey查找键是否存在
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
        Collection values = map.values();
        //2种
        Set entryset = map.entrySet();
        for (Object o : entryset) {
            Map.Entry entry = (Map.Entry)o;
            System.out.println();

        }


    }
}
