/**
 * 作者：张鹏烨
 * 2025/8/31
 **/
public class work {
    public static Node fun( Node first){
        Node cer = first;
        Node temp = null;
        Node prve = null;
        while (cer != null ){
            temp = cer.next;
            cer.next = prve;
            prve = cer;
            cer = temp;
        }
        return prve;
    }
    public static void main(String[] args) {
        Node i = new Node(1);
        Node j = new Node(2);
        Node p = new Node(3);
        i.next = j;
        j.next = p;
        Node o = fun(i);
        while(o!=null){
            System.out.println(o.i);
            o = o.next;

    }
}}
class Node{
    Node next;
    int i;

    public Node(int i) {
        this.i = i;
        this.next = null;
    }

}





