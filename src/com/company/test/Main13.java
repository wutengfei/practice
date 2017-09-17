package com.company.test;


import java.util.Scanner;

/**
 * 选课是否冲突
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] c = new int[a];
        int d = 0;
        String[][] b = new String[a][2];
        for (int j = 0; j < a; j++) {
            for (int i = 0; i < 2; i++) {
                b[j][i] = sc.next();
            }
        }
        for (int i = 0; i < a - 1; i++) {
            for (int j = i + 1; j < a; j++) {
                int flag = 0;
                if (b[i][0].equals(b[j][0])) {
                    flag++;
                    b[i][1] = b[i][1] + " " + b[j][1];
                }
                if (flag > 0)
                    c[d++] = i;
            }
        }
        if (d > 0) {
            for (int j = 0; j < d; j++) {

                System.out.println(b[c[j]][0] + " " + b[c[j]][1]);
            }
        }
        else
            System.out.println("YES");
    }
}
