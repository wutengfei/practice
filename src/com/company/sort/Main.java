package com.company.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 常用排序算法
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//获取控制台输入的第一个整数
        //获取n个整数
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        print(array);
        bubbleSort(array);
        quickSort(array, 0, array.length - 1);
        insertSort(array, 0, array.length - 1);
        mergeSort(array, 0, array.length - 1);
        selectionSort(array);
        shellSort(array, array.length);
        Arrays.sort(array);//快排
        Arrays.sort(array, 0, array.length);
        Arrays.copyOf(array, array.length);//把原数组复制前n个元素到新数组，返回值为新数组
        print(array);
    }

    // 打印每次排序结果
    public static void print(int array[]) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    //冒泡排序法
    public static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                print(array);
            }

        }
    }

    //选择排序法
    public static void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {// 第i个和第j个比较j可以取到最后一位，所以要用j<array.length
                if (array[i] > array[j]) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            // 打印每趟排序结果
            print(array);
        }
    }

    //插入排序法
    public static void insertSort(int[] array, int first, int last) {
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
            print(array);
        }
    }

    //希尔排序法
    public static void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {// 计算gap大小
            for (i = gap; i < n; i++) {// 将数据进行分组
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {// 对每组数据进行插入排序
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
                // 打印每趟排序结果
                print(array);
            }
        }
    }

    //归并排序法
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        mergeSort(array, left, center);
        // 对右边数组进行递归
        mergeSort(array, center + 1, right);
        // 合并
        merge(array, left, center, right);
        // 打印每次排序结果
        print(array);

    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param array  数组对象
     * @param left   左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right  右数组最后一个元素的索引
     */
    public static void merge(int[] array, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[array.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (array[left] <= array[mid]) {
                tmpArr[third++] = array[left++];
            } else {
                tmpArr[third++] = array[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = array[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = array[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            array[tmp] = tmpArr[tmp++];
        }
    }

    //快速排序法
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
}
