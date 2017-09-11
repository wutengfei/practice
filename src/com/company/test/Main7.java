package com.company.test;

import java.util.Scanner;

/**
 * 京东 括号匹配题  http://blog.csdn.net/shengmingqijiquan/article/details/77899281
 * 将删除右括号做了一个等价变换，变成删左括号。代码先统计最左边连续左括号的数量，当遇到第一个右括号时，
 * 对于前面的n个左括号，我们可以将其中任意一个左括号和这个右括号删除，那么剩下的括号还是一个合法的括号序列。
 * 最后将所有情况乘起来就是结果了
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int time = 1, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {//先统计最左边连续左括号的数量n
                left++;
            } else {//第一个右括号出现，此时移除一组左右括号
                time *= left;//其左边有n个左括号所以有乘以n种方法
                left--;//去掉一个左括号
            }
        }
        System.out.println(time);
    }

    /**
     * 将字符串从左至右压栈，如果是单独一个“（”，那么继续压，如果碰到了“）”，说明“（”已经输入完毕了，
     * 此时栈的大小就是左括号的数量，此时每输入一个右括号，就出一次栈，记录一次站内字符数，然后连乘，直到全部出栈。
     */
  /*  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] s = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            int num = 1;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '(') {
                    stack.push(s[i]);
                } else {
                    num *= stack.size();
                    stack.pop();
                }
            }
            System.out.println(num);
        }

    }*/

}
