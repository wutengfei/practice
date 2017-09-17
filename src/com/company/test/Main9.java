package com.company.test;

import java.util.Scanner;

import static java.lang.Integer.max;

public class Main9 {
    static int[][] e;
    static int[][] d;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j;

        n = sc.nextInt();
        int[][] d = new int[n][n];
        e = new int[n][n];
        for (i = 1; i <= n; i++)
            for (j = 1; j <= i; j++) {
                d[i][j] = sc.nextInt();
                e[i][j] = -1;
            }
        System.out.println(MaxSum(1, 1));

    }

    private static int MaxSum(int i, int j) {
        {
            if (e[i][j] != -1)
                return e[i][j];
            if (i == n)
                e[i][j] = d[i][j];
            else {
                int x = MaxSum(i + 1, j);
                int y = MaxSum(i + 1, j + 1);
                e[i][j] = max(x, y) + d[i][j];
            }
            return e[i][j];
        }
    }
}



