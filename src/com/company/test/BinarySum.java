package com.company.test;

import java.util.Scanner;

/**
 * 二进制求和
 * 输入：String类型a，b如：11   1
 * 输出：100
 */
public class BinarySum {

    private static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int alen = a.length(), blen = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;//进位上的数，如1+1=10，进位是1
        int i = 0;
        for (; i < blen; i++) {
            int sum = carry + a.charAt(alen - 1 - i) + b.charAt(blen - 1 - i) - 2 * '0';
            int cur = sum % 2;
            carry = sum / 2;
            sb.insert(0, cur);
        }
        for (; i < alen; i++) {
            int sum = carry + a.charAt(alen - 1 - i) - '0';
            int cur = sum % 2;
            carry = sum / 2;
            sb.insert(0, cur);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(addBinary(a, b));
    }
}
