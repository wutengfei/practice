package com.company.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] array) {
        int temp, t;
        for (int i = 0; i < array.length - 1; i++) {
            temp = i;
            for (int j = i + 1; j < array.length; j++) {//从第二个数开始到最后一个数
             // 如果有比array[temp]小的就把他的下标赋给临时变量temp，array[temp]始终为最小值
                if (array[j] < array[temp])
                    temp = j;
            }
            //交换array[j] 和 array[i]
            t = array[temp];
            array[temp] = array[i];
            array[i] = t;

            // 打印每趟排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 1, 3, 8, 9, 7, 4, 6};
        selectionSort(array);
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}