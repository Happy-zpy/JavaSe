package com.data.Search;
import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class FibonaccSearch {
    public static int[] fib(){
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 20; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
    public static int fibSearch(int[] arr,int value){
        int low = 0;
        int k = 0;
        int high = arr.length - 1;
        int mid;
        int[] f = fib();
        while(high > f[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,f[k]);
            for (int i  = high + 1; i  < temp.length; i ++) {
                 temp[i] = arr[high];
        }

        while(low <= high) {
            mid = low + f[k - 1] - 1;
            if (value < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                low = mid + 1;
                k -= 2;
            }
            else {
                if (mid < high){
                    return mid;
                }
                else return high;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,44,55,77,78,98,999};
        int i = fibSearch(arr,999);
        System.out.println(i);
    }
}
