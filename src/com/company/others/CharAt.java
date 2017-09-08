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


        String b = " a将";
        int d = 343454354;
        long f = 12345678903551515L;
        System.out.println("b=" + b.length());
        System.out.println(f);

    }
}
