package com.company.sort;

/**
 * 通俗易懂的快排
 * https://blog.csdn.net/vayne_xiao/article/details/53508973
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
            while (a[j] >= temp && i < j)
                j--;
            while (a[i] <= temp && i < j)
                i++;
            //交换a[left]、a[right]
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                print(a);
            }
        }
        //基准数归位
        a[left] = a[i];
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