package com.company.test;

import java.util.*;

public class QuChongAndSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().trim();

        String[] a = string.split(" ");
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        sortAndCount(b, b.length);
    }

    //这里有三个问题：排序、统计元素个数、去重。统计元素个数应在去重之前，去重后再排序
    public static void sortAndCount(int array[], int length) {
        //1、统计元素出现次数。用一个Map来记录某个元素的出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //存储Map<array[i],count> map中键是不允许重复的
        int count;
        for (int i = 0; i < length; i++) {
            count = 0;
            for (int j = 0; j < length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            map.put(array[i], count);
        }

        //2、去除数组中的重复元素个数。新开一个数组，原数组元素在新开数组中没有则加入
        int b[] = new int[length];
        int index = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
                b[index] = array[i];
                index++;
            }
        }

        //3、将数组b[]排序
        Arrays.sort(b, 0, index - 1);
        //4、输出
        for (int i = 0; i < index; i++) {
            System.out.print(b[i] + "[" + map.get(b[i]) + "]" + " ");
        }
    }

}