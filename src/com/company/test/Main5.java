package com.company.test;
/**
 *滴滴笔试
 * 丑数
 */

import java.util.Scanner;

public class Main5 {
    static int j = 0;
    static int d[];
static  int a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         a = in.nextInt();
        d = new int[a];
        int j = 0;
        for (int i = 1; i <= a; i++) {
          d[j++]= fun(i);
            if (j==a)

            System.out.println(fun(i));
        }
    }

    public static int fun(int n) {
        if(n<=0) return 0;
        int[] a=new int[n];
        a[0]=1;
        int begin=1,m2=0,m3=0,m5=0;
        while(begin<n){
            a[begin]=min(a[m2]*2,a[m3]*3,a[m5]*5);//大于当前最大丑数的最小数
            while((a[m2]*2<=a[begin])){
                m2++;
            }
            while((a[m3]*3<=a[begin])){
                m3++;
            }
            while((a[m5]*5<=a[begin])){
                m5++;
            }
            begin++;
        }
        return a[n-1];
    }
    public static int min(int i, int j, int k) {
        int a=i<j?i:j;
        return a<k?a:k;
    }
}
