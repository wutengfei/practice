package com.company.sort;

/**
 * 直接插入排序法
 * 插入排序原理很简单，将一组数据分成两组，分别将其称为有序组与待插入组。
 * 每次从待插入组中取出一个元素，与有序组的元素进行比较，并找到合适的位置，将该元素插到有序组当中。
 * 就这样，每次插入一个元素，有序组增加，待插入组减少。直到待插入组元素个数为0。
 * https://blog.csdn.net/llzk_/article/details/51628574
 */
public class InsertSort {
    public static void insertSort(int[] array, int first, int last) {
        int temp, i, j;
        for (i = first + 1; i <= last; i++) {// 默认以第一个数为有序序列，后面的数为要插入的数。
            temp = array[i];//从待插入组取出第一个元素。
            j = i - 1;///i-1即为有序组最后一个元素（与待插入元素相邻）的下标
            while (j >= 0 && array[j] > temp) {// 从有序序列的最后一个元素开始搜索，
                // 如果搜索到的数比temp大，则该数后移一位，继续搜索直到搜索到小于或等于temp的数即可
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;//while循环找到了合适位置j，因此array[j+1]应是temp应存放的位置
            // 打印每次排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 1, 3, 8, 9, 7, 4, 6};
        insertSort(array, 0, array.length - 1);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}