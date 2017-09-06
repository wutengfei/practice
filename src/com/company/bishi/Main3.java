package com.company.bishi;

import java.util.Scanner;

/**
 * Created by dell on 2017/9/6.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        boolean[][] dp = new boolean[n][n];
        int res = n;
          //任意一点与和它相距gap距离的点比较。
        for (int gap = 2; gap < n - 1; gap++)
            for (int i = 0; i < n; i++) {
                if (!dp[i][(i + gap) % n] && !dp[(i + gap) % n][i]) {
                    int k = gap - 1;
                    boolean b = true;
                    while (k > 0) {
                        if (!(arr[(i + k) % n] <= arr[(i + gap) % n] && arr[(i + k) % n] <= arr[i]))
                            b = false;
                        k--;
                    }
                    if (b) {
                        dp[i][(i + gap) % n] = true;
                        dp[(i + gap) % n][i] = true;
                        res++;
                    }
                }
            }
        System.out.println(res);
    }
}
