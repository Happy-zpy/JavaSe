package com.data.Sorting.Bubble;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/12
 **/
public class bubble01 {
      public static void fun(int[] arr){
          int temp;
          for (int i = 0; i < arr.length - 1; i++) {
              for (int j = 0; j < arr.length - 1 - i; j++) {
                  if(arr[j] > arr[j + 1]){
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
              System.out.println("第"+(i + 1)+"排序后");
              System.out.println(Arrays.toString(arr));
          }
      }

    public static void main(String[] args) {
        int[] i = {7,6,5,4,3,2,1};
        fun(i);
    }
}
