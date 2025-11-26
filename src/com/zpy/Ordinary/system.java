package com.zpy.Ordinary;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 **/
public class system {
    public static void main(String[] args) {
        System.out.println("kk");
        //System.exit(0);//0表示正常退出程序
        int[]i = {1,2,3};
        int[]p = new int[3];
        System.arraycopy(i,0,p,2,1);
        System.out.println(Arrays.toString(p));

    }
}
