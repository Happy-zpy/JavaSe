package com.data.pre;

import java.util.Objects;

/**
 * 作者：张鹏烨
 * 2025/9/4
 **/
public class linkedlistinboth {
    public static void main(String[] args) {
        NODE1 n1 = new NODE1(1,"宋江","及时雨");
        NODE1 n2 = new NODE1(2,"卢俊义","玉麒麟");
        NODE1 n3 = new NODE1(3,"林冲","豹子头");
        NODE1 n4 = new NODE1(4,"武松","行者");
        doublelinkedlist list = new doublelinkedlist();
        list.add(n1);
        list.add(n2);
        System.out.println(n2.pre);
        list.add(n3);
        System.out.println(list.size());
        list.add(n4,1);
        list.show();
        System.out.println(list.get(2));
        list.remove(n1);
        list.remove(1);
        list.show();
    }
}
class doublelinkedlist{
    NODE1 head = new NODE1(0,"","");
    public void add(NODE1 node1){
       NODE1 temp = head;
       while(true){
           if (temp.next == null){
               break;
           }
           temp = temp.next;
       }
       temp.next = node1;
       node1.pre = temp;
    }
    public void add(NODE1 node1 , int i) {
        if (i > size()) {
            this.add(node1);
            return;
        }
        NODE1 temp = head;
        int sum = 0;
        while (true) {
            if (sum == i){
                break;
            }
            temp = temp.next;
            sum++;
        }
        node1.next = temp;
        temp.pre.next = node1;
        node1.pre = temp.pre;
        temp.pre = node1;
    }
    public void remove(NODE1 node1){
        NODE1 temp = head;
        NODE1 cer;
        if(temp.next == null){
            System.out.println("链表为空");
            return;
        }
        while(true) {
            temp = temp.next;
            if (temp.equals(node1)) {
                break;
            }
        }
        cer = temp.next;
        temp.pre.next = cer;
        if (cer != null) {
            cer.pre = temp.pre;
        }


    }
    public void remove(int i){
        this.remove(get(i));
    }

     public NODE1 get(int i){
         NODE1 temp = head;
         int sum = 0;
         while (true) {
             if (sum == i){
                 break;
             }
             temp = temp.next;
             sum++;
         }
         return temp;
     }
    public int size(){
        int sum = 0;
        NODE1 temp = head.next;
        while (temp != null){
            sum++;
            temp = temp.next;
        }
    return sum;
    }
    public void show(){
        NODE1 temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

}
class NODE1{
    public String name;
    public int no;
    public String nickname;
    NODE1 next = null;
    NODE1 pre = null;

    public NODE1(int no, String nickname, String name) {
        this.no = no;
        this.nickname = nickname;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NODE{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NODE1 node1)) return false;
        return no == node1.no && Objects.equals(name, node1.name) && Objects.equals(nickname, node1.nickname);
    }

}
