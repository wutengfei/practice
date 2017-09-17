package com.company.test;
/*
*输入一个数组，对数组进行排序，并输出该数组中重复元素出现的次数
* 如：78,67,98,21,6,9,78,78,78,21
* 输出：6[1],9[1],21[2],67[1],78[4],98[1]
*/

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

    //这里有三个问题：排序、统计各个元素个数、去重。统计元素个数应在去重之前，去重后再排序
    //1、统计个数。用一个Map来记录某个元素的出现次数
    public static void sortAndCount(int array[], int length) {
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

        //2_方法1 去重。新开一个数组，原数组元素在新开数组中没有则加入
//       int b[] = new int[length];
//        Arrays.sort(array);
//        b[0] = array[0];
//        int j = 1;
//        for (int i = 1; i < length; i++) {
//            if (array[i] != array[i - 1]) {
//                b[j++] = array[i];
//            }
//        }

        //2_方法2
        int b[] = new int[length];
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
                b[j] = array[i];
                j++;
            }
        }
        Arrays.sort(b, 0, j - 1);


        //3、输出
        for (int i = 0; i < j; i++) {
            System.out.print(b[i] + "[" + map.get(b[i]) + "]" + " ");
        }
    }

}
