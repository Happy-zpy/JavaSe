package com.data.recursion.maze;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/10
 **/
public class maze01 {
   static int[][] arr;

    public maze01() {
        this.arr = new int[8][7];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < 7; i++) {
            arr[0][i] = 1;
            arr[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
    }

    @Override
    public String toString() {
        return "maze01{" +
                "arr=" + Arrays.deepToString(arr) +
                '}';
    }
    static boolean sway(int i,int j){
        if(i == 6 && j == 5){
            arr[i][j] = 2;
            return true;
        }
        if(arr[i][j] == 0){
            arr[i][j] = 2;
            if(sway(i-1,j)){
                return true;
            }
            else if(sway(i,j + 1)){
                return true;
            }
            else if(sway(i + 1,j)){
                return true;
            } else if (sway(i,j - 1)) {
                return true;

            }
            else
            {
                arr[i][j] = 3;
                return false;
        }}
        else return false;

    }

    public static void main(String[] args) {
        new maze01();
        arr[1][3] = 1;
        arr[2][3] = 1;
        sway(1,1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
            new Thread();
        }
    }
}
