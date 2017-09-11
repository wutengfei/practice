package com.company.test;
/**
 * 滴滴笔试  丑数
 * 我们把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第1500个丑数。
 *
 * 解题思路：根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果（1除外）。因此我们可以创建一个数组，
 * 里面的数字是排好序的丑数。里面的每一个丑数是前面的丑数乘以2、3或者5得到的。这个思路的关键点，
 * 就是要保证数组里面的丑数是排好序的。假设arr[1..i]是已经排好序的数组，则arr[i]一定是这里面最大的数，
 * 那么我们只要去寻找新生成的数字中比arr[i]大的的最小的数。新生成的数是由前面的数字*2或*3或*5得到的。
 * 我们定义index2为前面数字*2中的所有数字中满足大于arr[i]的最小的数的下标，index3,index5类似定义，
 * 则应该放在arr[i+1]位置的数字便是min(arr[index2]*2,arr[index3]*3,arr[index5]*5)。

 注意代码里，index2，index3，index5是维持动态向前的，不会产生无效搜索，因为当前找的数字一定比原来找的要大，
 所以从上一次找到的下标开始进行搜索就可以了。
 */

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(fun(a));
    }

    public static int fun(int n) {//第n个丑数
        if (n <= 0) return 0;
        int[] a = new int[n];
        a[0] = 1;
        int end = 1, m2 = 0, m3 = 0, m5 = 0;
        while (end < n) {//当数组中产生的最后一个丑数的下标=目标丑数的下标时结束循环
            a[end] = min(a[m2] * 2, a[m3] * 3, a[m5] * 5);//大于当前最大丑数的最小数
            while ((a[m2] * 2 <= a[end])) {
                m2++;
            }
            while ((a[m3] * 3 <= a[end])) {
                m3++;
            }
            while ((a[m5] * 5 <= a[end])) {
                m5++;
            }
            end++;
        }
        return a[n - 1];
    }

    public static int min(int i, int j, int k) {
        int a = i < j ? i : j;
        return a < k ? a : k;
    }
}
