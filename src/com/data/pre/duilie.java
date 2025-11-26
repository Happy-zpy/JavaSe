package com.data.pre;

import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/1
 **/
public class duilie {
    public static void main(String[] args) {
        queue p = new queue(6);
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                p.add(scanner.nextInt());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class queue{
    private int front = -1;
    private int reat = -1;
    public int arr[];

    public queue(int i) {
        this.arr = new int[i];
    }
    public int[] add(int i) throws Exception {
        if(reat == arr.length - 1){
            throw new Exception("队列已满");

        }
        reat++;
        arr[reat] = i;
        return arr;
    }
    public int get(){
        front++;
        return arr[front];
    }
}