package com.company.test;

import java.util.Scanner;

/**
 * 最大子数组问题：
 * 第一行输入一个整数n，第二行输入一个整形数组a[n]，数组里有正数也有负数。 数组中连续的一个或多个整数组成一个子数组，
 * 每个子数组都有一个和。求所有子数组的和的最大值以及子数组下标。要求时间复杂度为O(n)。
 * 例如
 * 8
 * 8 -4 6 -1 3 7 2 -3，和最大的子数组为8,-4,6,-1,3,7,2， 因此输出为该子数组的和21，下标为0和6。
 * 输出
 * 21 0 6
 */
public class MaxChildArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
        }
        subarraySum1(b);
        subarraySum2(b);
    }

    //暴力法求最大子数组和问题
    private static void subarraySum1(int[] a) {

        int sum = -10000;//记录子数组的和
        int low = 0;//记录子数组的底
        int high = 0;//记录子数组的高
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int subarraysum = 0;//所遍历出来的子数组的和
                //计算遍历的子数组之和
                for (int k = i; k <= j; k++) {
                    subarraysum += a[k];
                }
                //找出最大的子数组
                if (subarraysum > sum) {
                    sum = subarraysum;
                    low = i;
                    high = j;
                }
            }
        }
        System.out.println(sum + " " + low + " " + high);
    }

    /*算法思想：重复利用已经计算的子数组和。
    例如sum(i,j)=sum(i,j-1)+aj,即sum+=a[j],因此省去了计算sum(i,j-1)的时间。
    */
    private static void subarraySum2(int[] a) {
        int maxSum = Integer.MIN_VALUE;//记录最大子数组的和
        int low = 0;//记录最大子数组的底
        int high = 0;//记录最大子数组的高
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            //      for (int j = i + 1; j >= 0; j--) {
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    low = i;
                    high = j;
                }
            }
        }
        System.out.println(maxSum + " " + low + " " + high);
    }

}




