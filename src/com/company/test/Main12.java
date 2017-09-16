package com.company.test;

/**
 * 折半查找法，求排序数组中某个元素的下标
 */
public class Main12 {
    public static void main(String[] args) {

        int[] a = {1, 4, 5, 6, 7, 8};
        System.out.println(bin_search(a, a.length, 6));
    }

    private static int bin_search(int a[], int n, int v) {
        int low, high, mid;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == v) return mid;
            if (a[mid] < v) {
                low = mid + 1;
            }
            if (a[mid] > v) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
