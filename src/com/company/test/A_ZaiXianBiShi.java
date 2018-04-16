package com.company.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 吴腾飞 on 2018/4/15.
 * 在线考试输入规则模板
 */
public class A_ZaiXianBiShi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String a = in.nextLine().trim();
            String b = in.nextLine().trim();
            int c = Integer.parseInt(a);
            String[] d = b.split(" ");
            System.out.println("n=" + a + "\nb[]=" + Arrays.toString(d));

          //  int e = in.nextInt();
        }
    }
}
