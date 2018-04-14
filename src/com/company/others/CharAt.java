package com.company.others;

/**
 * Created by dell on 2017/4/5.
 */
public class CharAt {
    public static void main(String arg[]) {
        String str = "ab,c,de,fg,h";
        String[] a = str.split(",", 2);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


        String b = "hello 你好";
        int d = 343454354;
        long f = 12345678903551515L;
        System.out.println("b.length=" + b.length());
        System.out.println("b.charAt=" + b.charAt(5));
        System.out.println("b.charAt=" + b.substring(2,7));
        System.out.println(f);

    }
}
