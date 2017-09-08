package com.company.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
 * 度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 输入描述:
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * 输出描述:
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * <p>
 * 输入例子1:
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 * 输出例子1:
 * 30
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int[] c = newArray(array);
        if (c.length < 3)
            System.out.print(-1);
        else
            System.out.print(c[2]);
    }

    public static int[] newArray(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[0];
        int j = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                b[j++] = a[i];
            }
        }
        return Arrays.copyOf(b, j);
    }
}