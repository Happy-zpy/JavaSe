package com.data.recursion.Queen;

/**
 * 作者：张鹏烨
 * 2025/9/11
 **/
public class queen8 {
    public static void main(String[] args) {
        d i = new d();
        i.check(0);
        System.out.println(i.num);

    }

}
class d{
    int max = 8;
    int arr[];
    int num = 0;

    public d() {
        arr = new int[8];
    }
    public void check(int n){
        if(n == 8){
            print();
            return;
        }
        for(int i = 0;i < max;i++){
            arr[n] = i;
            if (juge(n)){
                check(n + 1);
            }
        }

    }
    public boolean juge(int n){
        for (int i = 0; i < n; i++) {
          if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n]) ){
              return false;
          }
        }
        return true;
    }
    public void print(){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        num++;
    }
}