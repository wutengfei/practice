package com.company.test;
/**
 * 时间限制：2秒
 * 空间限制：65536K
 * <p>
 * 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。
 * 首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，
 * 小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。
 * 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，
 * 则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。
 * 满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，
 * 一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，
 * 她希望你能够帮她解决这个问题。
 * 输入描述:
 * 输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，
 * 第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.
 * <p>
 * 输出描述:
 * 对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
 * 输入例子1:
 * 5
 * 1 2 4 5 3
 * 输出例子1:
 * 7
 */

import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(communications(arr));
        }
    }

    /**
     * 拿到圆环中下一个元素的索引，因为这里是用数组来表示圆环的
     */
    public static int nextIndexInCircle(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    /**
     * 单调栈中在栈顶相遇的相同元素之间构成的可观察岗哨对数
     */
    public static long getInternalSum(int n) {
        return n == 1 ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    public static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        int value = arr[maxIndex]; // 先找到数组中的一个最大值（可能不止一个）
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value)); // 先把最大值压入单调栈栈底
        long res = 0L;
        int index = nextIndexInCircle(size, maxIndex);
        while (index != maxIndex) {
            value = arr[index];
            while (!stack.isEmpty() && value > stack.peek().value) { // 来了一个更大的元素
                int times = stack.pop().times; // 栈顶元素出栈，并拿到该栈顶元素的累计个数
                // 出栈的栈顶元素之间构成可观察岗哨对数C(times)2 = n*(n-1)/2，当times==1时，构成的可观察岗哨对数为0
                // 出栈的栈顶元素与它下面的元素以及使它出栈的元素所构成的可观察岗哨对数times * 2
                res += getInternalSum(times) + times * 2;
            }
            if (!stack.isEmpty() && value == stack.peek().value) { // 累加栈顶相遇的相同元素个数
                stack.peek().times++;
            } else { // stack.isEmpty() || value < stack.peek().value
                stack.push(new Pair(value));
            }
            index = nextIndexInCircle(size, index);
        }
        while (!stack.isEmpty()) { // 所有的元素都已遍历了一遍，单调栈不空
            int times = stack.pop().times;
            res += getInternalSum(times); // 相同元素之间构成的可观察岗哨对数
            if (!stack.isEmpty()) {
                res += times; // 与它下面的元素所构成的可观察岗哨对数 [此处标记]
                if (stack.size() >= 2) { // 它下面并不是栈底最大值
                    res += times; // 与栈底最大值所构成的可观察岗哨对数
                } else { // 它下面已是栈底最大值
                    res += stack.peek().times == 1 ? 0 : times; // 如果它下面的栈底最大值只有1个，显然它已经在有[标记]的那一行加过了
                }
            }
        }
        return res;
    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }
}