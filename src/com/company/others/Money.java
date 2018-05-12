package com.company.others;

import java.util.Scanner;

/**
 * Created by 吴腾飞 on 2018/4/15.
 * 货币面值问题，给你一个n种面值的货币系统，求组成面值为m的货币有多少种方案。
 * Input
 * 输入有多组数据，每组数据第一行：n,m的值，第二行n个数为每种货币的面值。
 * Output
 * 对于每组数据输出组成面值为m的货币的方案数。
 *样例：
 * 输入：
 * 3 10
 *1 2 5
 * 输出：
 * 10
 * 解：类似完全背包问题
 */
public class Money {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(fun(a, n, m));
        }
    }

    private static int fun(int[] a, int n, int m) {
        int[] f = new int[10000];
        f[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = a[i];
                 j <= m; j++)
                f[j] += f[j - a[i]];
        return f[m];
    }


}