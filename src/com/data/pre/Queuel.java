package com.data.pre;
import java.util.Scanner;
/**
 * 作者：张鹏烨
 * 2025/9/2
 **/
public class Queuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CirclarQueue p = new CirclarQueue(6);

        boolean loop = true;
        while(loop){
            System.out.println("展示s");
            System.out.println("添加a");
            System.out.println("取出g");
            System.out.println("推出e");
            char c = scanner.next().charAt(0);
            switch(c){
                case 's': try {
                    p.show();
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                };break;
                case 'a':
                    try {
                        int sum = scanner.nextInt();
                        p.addelement(sum);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }break;
                case 'g':
                    try {
                        p.getelement();
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }break;
                case 'e':loop = false;break;
                default:break;
            }
        }
        scanner.close();

    }
}

class CirclarQueue{
    private int front = 0;
    private int reat = 0;
    private int arr[];

    public CirclarQueue(int max) {
        this.arr = new int[max];
    }
    public boolean idempty(){
        return front == reat;
    }
    public boolean isfull(){
        return (reat + 1) % arr.length == front;
    }
    public int[] addelement(int ele) throws Exception {
        if(isfull()){
            throw new Exception("队列已满无法添加");
        }
        arr[reat] = ele;
        reat = (reat+1) % arr.length;
        return arr;
    }
    public int getelement() throws Exception{
        if(idempty()){
            throw new Exception("队列为空，无法取出");
        }
        int ele = arr[front];
        front = (front+1) % arr.length;
        return ele;
    }
    public void show() throws Exception{
        if (idempty()){
            throw new Exception("队列为空，无法展示");
        }
        for (int i = front;i < front +(reat + arr.length -front) % arr.length;i++){
            System.out.println("arr["+i+"]="+arr[(i)%arr.length]);
        }
    }



}
