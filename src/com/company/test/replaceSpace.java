package com.company.test;

import java.util.Scanner;

/**
 * 替换空格
 */
public class replaceSpace {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        System.out.println(replaceSpace(a));
    }

    public static String replaceSpace(String str) {
        char[] strChar = str.toCharArray();
        StringBuilder stb = new StringBuilder();
        for (char aStrChar : strChar) {
            if (aStrChar == ' ') {
                stb.append("%20");
            } else {
                stb.append(aStrChar);
            }
        }
        return stb.toString();
    }
}
