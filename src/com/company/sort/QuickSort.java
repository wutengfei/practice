package com.company.sort;

/**
 * 快速排序法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 1, 3, 8, 9, 7, 4, 6};
        print(array);  // 打印每次排序结果
        quickSort(array, 0, 8);
        print(array);
    }

    public static void quickSort(int[] array, int low, int height) {
        if (low < height) {
            int left = low;
            int right = height;
            int key = array[low];// 刚开始以第一个数为标志数据
            while (low < height) {
                while (low < height && array[height] >= key)
                    height--;// 从后面开始找，找到比key值小的数为止
                array[low] = array[height];// 将该数放到key值的左边
                while (low < height && array[low] <= key)
                    low++;// 从前面开始找，找到比key值大的数为止
                array[height] = array[low];// 将该数放到key值的右边
            }
            array[low] = key;// 把key值填充到low位置，下次重新找key值
            print(array);

            quickSort(array, left, low - 1); // 递归调用
            quickSort(array, low + 1, right);
        }
    }

    public static void print(int array[]) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}