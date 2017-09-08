package com.company.others;

import java.util.Scanner;

/**
 * Created by dell on 2017/7/7.
 * 回文数字
 */
public class huiWen {
    static int[] a = new int[5];
    static int[] b = new int[5];

    public static void main(String[] args) {
        boolean is = false;
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            long l = s.nextLong();
            if (l > 99999 || l < 10000) {
                System.out.println("Input error, please input again!");
                l = s.nextLong();
            }
            for (int i = 4; i >= 0; i--) {
                a[i] = (int) (l / (long) Math.pow(10, i));
                l = (l % (long) Math.pow(10, i));
            }
            for (int i = 0, j = 0; i < 5; ) {
                b[j++] = a[i++];
            }
            for (int i = 0, j = 4; i < 5; ) {
                if (a[i++] != b[j--]) {
                    is = false;
                    System.out.println("is not a palindrome!");
                    break;
                } else {
                    is = true;
                }
            }
            if (is) {
                System.out.println("is a palindrome!");
            }

        }
    }
}
