package com.company.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Unix简化路径
 * 样例
 * 输入/home/   输出 /home
 * 输入/a/./b/../../c/  输出/c
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(path(sc.nextLine()));
    }

    private static String path(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; ++i) {
            if (".".equals(strings[i]) || "".equals(strings[i]))
                continue;
            if ("..".equals(strings[i])) {
                if (!stack.empty())
                    stack.pop();
            } else
                stack.push(strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }
}

