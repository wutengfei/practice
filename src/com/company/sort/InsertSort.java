package com.company.sort;

/**
 * 直接插入排序法
 */
public class InsertSort {
    public void insertSort(int[] array, int first, int last) {
        int temp, i, j;
        for (i = first + 1; i <= last - 1; i++) {// 默认以第一个数为有序序列，后面的数为要插入的数。
            temp = array[i];
            j = i - 1;
            while (j >= first && array[j] > temp) {// 从后进行搜索如果搜索到的数小于temp则该数后移继续搜索，直到搜索到小于或等于temp的数即可
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            // 打印每次排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = { 5, 2, 1, 3, 8, 9, 7, 4, 6  };
        insertSort.insertSort(array, 0, array.length);// 注意此处是0-9而不是0-8
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}