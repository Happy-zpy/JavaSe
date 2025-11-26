package com.data.pre;

/**
 * 作者：张鹏烨
 * 2025/9/6
 **/
public class circular {
    public static void main(String[] args) {
        management management = new management();
        management.add(10);
       management.show();
        management.countboy(1,2);
    }
}
class management {
    public Boy first = new Boy(-1);
    public void add(int num) {
        if (num < 1) {
            System.out.println("数量不正确");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            return;
        }
        Boy cur = first;

        do {
            System.out.println(cur);
            cur = cur.getNext();
        } while (cur != first );

    }

    public void countboy(int start, int count) {
        Boy help = first;
        while (help.getNext() != first) {
            help = help.getNext();
        }

        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            help = help.getNext();
        }
        while (help != first) {
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                help = help.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();
            help.setNext(first);
        }
        System.out.println(first.getNo());
}
}


    class Boy {
        private int no;
        private Boy next = null;

        public Boy() {
        }

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +
                    '}';
        }
    }

