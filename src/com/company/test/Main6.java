package com.company.test;
/**
 *今日头条笔试题2
 * 测试用例未通过
 */

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b[] = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = in.nextInt();
        }
        int c = in.nextInt();
        int[][] d = new int[c][c];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = in.nextInt();
            }
        }

        for (int j = 0; j < c; j++) {

            int e = 0;
            for (int i = 0; i < a; i++) {
                if (d[j][0] <=b[i] && b[i] <= d[j][1]) {
                    if (d[j][2] == b[i])
                        e++;
                }

            }
            System.out.println(e);
        }
    }
}
