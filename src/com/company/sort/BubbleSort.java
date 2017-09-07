package com.company.sort;

/**
 * 冒泡排序法（升序）
 * 原理：从数组的第一个位置开始两两比较array[index]和array[index+1]，
 * 如果array[index]大于array[index+1]则交换array[index]和array[index+1]的位置，直到数组结束；
 * 从数组的第一个位置开始，重复上面的动作，直到数组长度减一个位置结束；
 * 从数组的第一个位置开始，重复上面的动作，直到数组长度减二个位置结束；
 */
public class BubbleSort {
    public static void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                //               //查看具体排序过程
//                for (int k = 0; k <= array.length - 1; k++) {
//                    System.out.print(array[k] + "\t");
//                }
//                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 1, 3, 8, 9, 7, 4, 6};
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        sort(array);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}  