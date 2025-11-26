package WORK;

/**
 * 作者：张鹏烨
 * 2025/9/8
 **/
@SuppressWarnings({"all"})
public class work03 {
}
@SuppressWarnings({"all"})
class NODE<T>{
    T t;
    NODE next = null;
    public NODE(T t) {
        this.t = t;
    }

    public NODE() {
    }

    @Override
    public String toString() {
        return "NODE{" +
                "t=" + t +
                '}';
    }
}
@SuppressWarnings({"all"})
class list{
    NODE first = new NODE<>();
    NODE cur = first;
    public void push(NODE node){
        if(first.next == null){
            first.next = node;
            cur = node;
            return;
        }
        NODE temp = first;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = node;
        cur = node;
    }
    public boolean isempty(){
        if (first.next == null){
            return true;
        }
        return false;
    }
    @SuppressWarnings({"all"})
    public NODE pop() throws Exception{
        if(isempty()){
           throw new Exception("栈为空");
        }
        NODE temp = cur;
        NODE pre = first;
        while(pre.next != temp){
            pre = pre.next;
        }
        pre.next = null;
        cur = pre;
        return temp;
    }
}