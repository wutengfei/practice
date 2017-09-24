package com.company.test;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[k][2];
        int[][] array = new int[n][m];
        for (int i = 0; i < k; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        for (int i = 0; i < k-1; i++) {
            if (a[i + 1][0] < a[i][0] || a[i + 1][1] < a[i][1]) {
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 1; i < a[0][0]; i++) {
            System.out.print("D");
        }
        for (int i = 1; i < a[0][1]; i++) {
            System.out.print("R");
        }

        for (int i = 0; i < k - 1; i++) {
            int x = a[i + 1][0] - a[i][0];
            int y = a[i + 1][1] - a[i][1];
            for (int j = 0; j < x; j++) {
                System.out.print("D");
            }
            for (int j = 0; j < y; j++) {
                System.out.print("R");
            }

        }

        for (int i = a[k-1][0]; i < n; i++) {
            System.out.print("D");
        }
        for (int i = a[k-1][1]; i < m; i++) {
            System.out.print("R");
        }
    }


}
