package com.data.pre;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/1
 **/
public class sparcearr {
    public static void main(String[] args) throws Exception {
        int[][] i = new int[11][11];
        i[2][3] = 4;
        i[3][4] = 5;
        for (int[] ints : i) {
            for (int i1 : ints) {
                System.out.print(i1 + "\t");
            }
            System.out.println();

        }
        int sum = 0;
        for (int[] ints : i) {
            for (int i1 : ints) {
                if (i1 != 0) {
                    sum++;
                }
            }}

        int[][] p = new int[sum + 1][3];
        p[0][0] = i.length;
        p[0][1] = i.length;
        p[0][2] = sum;
        int l = 1;
        for (int j = 0; j < i.length; j++) {
            for (int k = 0; k < i[j].length; k++) {
                if (i[j][k] != 0) {
                    p[l][0] = j;
                    p[l][1] = k;
                    p[l][2] = i[j][k];
                    l++;
                }
            }
        }
        System.out.println("===================================");
        for (int[] ints1 : p) {
            for (int i1 : ints1) {
                System.out.print(i1 + "\t");

            }
            System.out.println();
        }
        System.out.println("===================================");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\new03.txt"));
        oos.writeObject(i);
        oos.writeObject(p);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\new03.txt"));
        int[][] k = (int[][])ois.readObject();
        for (int[] ints1 : k) {
            for (int i1 : ints1) {
                System.out.print(i1 + "\t");

            }
            System.out.println();
        }
        System.out.println("=======================================");
        int[][] j = (int[][])ois.readObject();
        for (int[] ints1 : j) {
            for (int i1 : ints1) {
                System.out.print(i1 + "\t");

            }
            System.out.println();
        }


    }
}
