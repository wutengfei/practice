package com.company.others;

import java.util.Scanner;

/**
 * 余弦相似度算法
 * Created by Fly Wu on 2017/12/18.
 */
public class CosineSimilar {
    public static void main(String[] args) {
        //int[] a={1,1,2,0,1,1,1};
       // int[] b={1,1,1,0,1,2,0};
       // System.out.println(cosine(a,b));
        System.out.println("请输入a向量：");
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        char[] aa=str1.toCharArray();
        int[] aaa = new int[aa.length];
        for (int i = 0; i < aa.length; i++) {
            aaa[i]=(int)aa[i]-48;
        }

        System.out.println("请输入b向量：");
        String str2=scanner.nextLine();
        char[] bb=str2.toCharArray();
        int[] bbb = new int[aa.length];
        for (int i = 0; i < aa.length; i++) {
            bbb[i]=(int)bb[i]-48;
        }
       System.out.println("余弦相似度为"+cosine(aaa,bbb));
    }
    public static double cosine(int[] a , int[] b){

        double member=0;//分子
        double denominator;//分母
        for (int i = 0; i < a.length; i++) {
            member+= a[i]*b[i];
        }
        double c=0,d=0;
        for (int i = 0; i < a.length; i++) {
            c+=a[i]*a[i];
            d+=b[i]*b[i];
        }
        denominator= ((Math.sqrt(c))*Math.sqrt(d));
        double  result=member/denominator;
        return result;
    }
}
