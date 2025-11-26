package com.data.pre;

/**
 * 作者：张鹏烨
 * 2025/9/7
 **/
public class stack {
    int top = -1;
    int down = -1;
    int max;
    int[] arr;
    public stack(int max) {
        this.arr = new int[max];
        this.max = max;
    }
    public void add(int i){
        if(isfull()){
            System.out.println("栈已经满了，无法继续添加");
            return;
        }
        top++;
        arr[top] = i;
    }
    public void show(){
        if (isempty()) {
            System.out.println("此站为空栈");
        }
        int i = 0;
        for(;i <= top;i++){
            System.out.println(arr[i]);
        }
    }
    public void get(){
        System.out.println(arr[top]);
        top--;
    }
    public boolean isempty() {
        if (top == down) {
            return true;
        }
        else {
            return false;
        }

    }
    public boolean isfull(){
        if(top == max-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
