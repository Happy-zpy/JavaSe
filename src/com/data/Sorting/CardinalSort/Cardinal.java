package com.data.Sorting.CardinalSort;

/**
 * 作者：张鹏烨
 * 2025/9/18
 **/

import java.util.Arrays;
public class Cardinal {

    // 基数排序主方法
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找到数组中的最大值，确定最大位数
        int max = findMax(arr);
        int digitCount = getDigitCount(max);

        // 2. 进行digitCount趟排序（从最低位到最高位）
        for (int i = 0; i < digitCount; i++) {
            // 对第i位进行排序（i=0表示个位，i=1表示十位，以此类推）
            countSort(arr, i);
        }
    }

    // 辅助方法：找到数组中的最大值
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // 辅助方法：计算一个数的位数
    private static int getDigitCount(int num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // 按指定位数进行计数排序（基数排序的每一趟）
    private static void countSort(int[] arr, int digit) {
        int radix = 10; // 十进制
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[radix];
        Arrays.fill(count, 0);

        // 1. 统计每个桶中的元素个数
        for (int num : arr) {
            int d = getDigit(num, digit);
            count[d]++;
        }

        // 2. 计算前缀和，确定每个元素在output中的位置
        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }

        // 3. 从后往前遍历，将元素放入output数组（保持稳定性）
        for (int i = n - 1; i >= 0; i--) {
            int d = getDigit(arr[i], digit);
            output[count[d] - 1] = arr[i];
            count[d]--;
        }

        // 4. 将排序结果复制回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 辅助方法：获取数字的第digit位（digit=0表示个位）
    private static int getDigit(int num, int digit) {
        // 计算10^digit，例如digit=0时为1，digit=1时为10
        int divisor = (int) Math.pow(10, digit);
        return (num / divisor) % 10;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("排序前: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}

