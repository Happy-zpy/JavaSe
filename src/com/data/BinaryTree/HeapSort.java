package com.data.BinaryTree;

/**
 * 作者：张鹏烨
 * 2025/9/28
 **/
public class HeapSort {
    public static void Heap(int[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr,0,i);
        }
    }
    public static void adjust(int[] arr,int i,int length){
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if(j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }
            if (arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }
            else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 7, 4, 8, 6, 2, 5};
        System.out.println("排序前: " + java.util.Arrays.toString(arr));

        Heap(arr);

        System.out.println("排序后: " + java.util.Arrays.toString(arr));
    }
}
