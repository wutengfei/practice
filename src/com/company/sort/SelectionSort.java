package com.company.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {// 第i个和第j个比较j可以取到最后一位，所以要用j<=array.length-1
                if (array[i] > array[j]) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            // 打印每趟排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = { 5, 2, 1, 3, 8, 9, 7, 4, 6  };
        selectionSort.selectionSort(array);
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}