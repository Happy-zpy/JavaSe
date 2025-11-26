package com.data.Search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 作者：张鹏烨
 * 2025/9/19
 **/
public class BinarySearch {
    public static List Binary(int[] arr, int value, int left, int right){
        ArrayList<Integer> list = new ArrayList<>();
        if(right < left){
            list.add(-1);
            return list;
        }
        int med = (left + right) / 2;
        if(value > arr[med]){
            return Binary(arr,value,med + 1,right);
        } else if (value < arr[med]) {
            return Binary(arr,value,left,med - 1);
        }
        else {
            list.add(med);
            int temp = med - 1;
            while (arr[temp] == value && temp >= 0){
                list.add(temp);
                temp--;
            }
             temp = med + 1;
            while( temp < arr.length && arr[temp] == value ){
                list.add(temp);
                temp++;
            }
            return list;


        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,66,77,99,99,99,99,99,99,99,99};
        List list = Binary(arr,99,0,arr.length - 1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
}
