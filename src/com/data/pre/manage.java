package com.data.pre;

/**
 * 作者：张鹏烨
 * 2025/9/3
 **/
public class manage {
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        NODE n1 = new NODE(1,"宋江","及时雨");
        NODE n2 = new NODE(2,"卢俊义","玉麒麟");
        NODE n3 = new NODE(3,"林冲","豹子头");
        list.orderadd(n3);
        list.orderadd(n1);
        list.orderadd(n2);
        list.show();
        System.out.println("=========================================");
        //NODE n4 = new NODE(3,"武松","行者");
        //list.update(n4);
        //list.show();
        //list.remove(1);
        //list.show();
        list.reserve();
        System.out.println("================");
        list.show();

    }
}
class linkedlist{
    NODE head = new NODE(0,"","");
    public void add(NODE node){
        NODE temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    public void orderadd(NODE node){
        NODE temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

    }

    public void show(){
        NODE temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }

    }
    public void reserve(){
        NODE temp = head.next;
        NODE cer = null;
        NODE pre = null;
        while(temp != null){
           cer = temp.next;
           temp.next = pre;
           pre = temp;
           temp = cer;
        }
        head.next = pre;

    }
    public void update(NODE node){
        NODE temp = head;
        boolean flag = true;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == node.no){
                flag = false;
                break;
            }

            temp = temp.next;
        }
        if (!flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }
        else {
            System.out.println("没找到");
        }
    }
    public void remove(int i){
        NODE temp = head;

        while(true){
            if(temp.next == null){
                break;
            }
            if (temp.next.no == i){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}

class NODE{
    public String name;
    public int no;
    public String nickname;
    NODE next = null;

    public NODE(int no, String nickname, String name) {
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
}
