package com.company.test;

import java.util.Scanner;

/**
 * 第一行输入一个整数n，第二行输入一个整形数组a[n]，数组里有正数也有负数。 数组中连续的一个或多个整数组成一个子数组，
 * 每个子数组都有一个和。求所有子数组的和的最大值以及子数组下标。要求时间复杂度为O(n)。
 * 例如
 * 8
 * 8 -4 6 -1 3 7 2 -3，和最大的子数组为8,-4,6,-1,3,7,2， 因此输出为该子数组的和21，下标为0和6。
 * 输出
 * 21 0 6
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
        }
        subarraySum1(b);
        subarraySum2(b);
        subarraySum3(b);
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

    /*算法思想：从数组的左边界开始，从左到右处理，记录到目前为止已经处理过的最大子数组。
    若已知A[1,2,....,j]的最大子数组，则A[1,2,.....,j,j+1]的最大子数组要么是A[1,2,....,j]的最大子数组，
    要么是某个子数组A[i,....,j+1](1<=i<=j+1)。
    */
    private static void subarraySum2(int[] a) {
        int maxSum = a[0];//记录最大子数组的和
        int low = 0;//记录最大子数组的底
        int high = 0;//记录最大子数组的高
        for (int i = 0; i < a.length - 1; i++) {
            int sum = 0;
            //寻找以A[i+1]为终点的最大子数组
            for (int j = i + 1; j >= 0; j--) {
                sum += a[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    low = j;
                    high = i + 1;
                }
            }
        }
        System.out.println(maxSum + " " + low + " " + high);
    }

    /**
     * 在线法求最大子数组和问题
     * 理解这个算法的关键是：使用thisSum来计算当前连续子数组的和，如果thisSum小于0，
     * 那么无论后面再加上什么数字都只会让子数组变小，所以抛弃当前子数组，重新开始计算子数组的值。
     * 可以看到这个算法的时间复杂度为O（n）而且控件复杂度为S（n），是解决这一个问题非常有效的一个算法。
     */
    private static void subarraySum3(int[] a) {
        int sum = 0;//记录子数组的和
        int thisSum = 0;
        int low = 0;//记录子数组的底
        int high = 0;//记录子数组的高
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > sum) {
                sum = thisSum;
                high = i;
            } else if (thisSum < 0) {
                thisSum = 0;
                low = i;
            }
        }
        System.out.println(sum + " " + low + " " + high);

    }

}




