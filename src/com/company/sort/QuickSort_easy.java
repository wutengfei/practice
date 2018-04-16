package com.company.sort;

/**
 * 通俗易懂的快排
 * https://blog.csdn.net/vayne_xiao/article/details/53508973
 * 每次以第一个数为基准数，先从右往左找到第一个比它小的数，再从左往右找到第一个比它大的数，
 * 然后交换两个数，继续找下去依次交换，直到左右两边相遇为止，这时交换相遇点与基准点的两个数，
 * 交换之后基准数左边全是比它小的数，右边全是比它大的数。
 * 然后基准数两边分别递归执行上述操作。
 */

public class QuickSort_easy {
    public static void main(String[] args) {
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        print(a);
        quickSort(a, 0, 9);
        print(a);
    }

    public static void quickSort(int[] a, int left, int right) {
        int temp = 0, i, j, t = 0;
        if (left > right)
            return;
        temp = a[left];
        i = left;
        j = right;
        while (i < j) {
            while (a[j] >= temp && i < j)//先从右往左找到比它小的数
                j--;
            while (a[i] <= temp && i < j)//再左往右找到比它大的数
                i++;
            //交换a[i]、a[j]
            if (i < j) {//如果没有这个判断会有多余的交换次数
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                print(a);
            }
        }
        //基准数归位
        a[left] = a[i];//while循环完毕之后i=j，所以用a[i],a[j]都可以
        a[i] = temp;
        print(a);
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    // 打印每次排序结果
    public static void print(int array[]) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}