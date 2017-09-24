package com.company.test;

import java.util.Scanner;

public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
        }
        int c = sc.nextInt();
        int[][] d = new int[c][2];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < c; i++) {
            if (d[i][1] - d[i][0] < 2)
                System.out.println(0);
            else {
                int t = 0;
                int count = 0;
                for (int j = d[i][0]; j <= d[i][1] - 2; j++) {
                    if (b[d[i][0] - 1 + t] <= b[d[i][0] + t] && b[d[i][0] + t] <= b[d[i][0] + 1 + t]) {
                        count++;

                    }
                    t++;
                }
                System.out.println(count);
            }
        }


    }
}
