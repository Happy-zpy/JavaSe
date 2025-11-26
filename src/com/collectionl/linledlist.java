package com.collectionl;

/**
 * 作者：张鹏烨
 * 2025/8/21
 **/
public class linledlist {
    public static void main(String[] args) {
       Node hh = new Node("hh");
       Node kk = new Node("kk");
       Node pp = new Node("pp");
       Node oo = new Node("oo");
       hh.next = kk;
       kk.next = oo;
       oo.next = pp;
       oo.pre = kk;
       pp.pre = oo;
       kk.pre = hh;
       Node first = hh;
       Node last = pp;
       while(true){
           if(first == null){
               break;
           }
           System.out.println(first);
           first = first.next;

       }
        while(true){
            if(last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;

        }
    }
}

class Node{
    Object inme;
    Node next;
    Node pre;

    public Node(Object inme) {
        this.inme = inme;
    }

    @Override
    public String toString() {
        return "Node{" +
                "inme=" + inme +
                '}';
    }
}