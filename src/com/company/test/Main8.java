package com.company.test;
/*
 * a,b,c,d四个点在坐标系中能组成正方形输出YES，否则输出NO
 * 输入
 * 第一行一个整数 代表n组数据
 * 之后一行输入横坐标
 * 之后输入纵坐标
 * 输入n组
 *例：
 * 输入
 * 3
 * 2 2 4 4
 * 4 2 2 4
 * 1 3 3 1
 * 1 1 3 3
 * 1 2 3 4
 * 4 5 2 4
 * 输出
 * YES
 * YES
 * NO
 */

import java.util.Scanner;

public class Main8 {
    private static int[][] a;
    private static int[][] b;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a = new int[n][4];
        b = new int[n][4];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 4; i++) {
                a[j][i] = in.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                b[j][i] = in.nextInt();
            }
        }
        double[][] s = new double[n][4];
        for (int j = 0; j < n; j++) {
            s[j][0] = fun(j, 1, 0);
            s[j][1] = fun(j, 2, 1);
            s[j][2] = fun(j, 3, 2);
            s[j][3] = fun(j, 0, 3);
        }
        for (int j = 0; j < n; j++) {
            if (s[j][0] == s[j][1] && s[j][2] == s[j][3] && s[j][1] == s[j][2])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static double fun(int j, int x, int y) {
        return Math.sqrt(Math.abs((a[j][x] - a[j][y]) * (a[j][x] - a[j][y])) +
                Math.abs((b[j][x] - b[j][y]) * (b[j][x] - b[j][y])));
    }
}