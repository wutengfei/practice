package com.company.bishi;

/**
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，
 * 现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，
 * 如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3，
 * 按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 * <p>
 * 输入描述:
 * 输入中有多组测试数据，每组测试数据为一个整数A(1 ≤ A ≤ 5000).
 * <p>
 * 输出描述:
 * 对每组测试数据，在单独的行中以X/Y的形式输出结果。
 * <p>
 * 示例1
 * 输入
 * 5
 * 3
 * 输出
 * 7/3
 * 2/1
 */

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int sum = 0;
            for (int i = 2; i < a; i++) {
                sum += transform(a, i);
            }

            int d = gcd(sum, a - 2);
            System.out.println(sum / d + "/" + (a - 2) / d);

        }

    }

    /**
     * 辗转相除法
     * @param a 被除数  a>b
     * @param b 除数
     * @return 最大公约数
     */
    private static int gcd(int a, int b) {
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }

    private static int transform(int a, int n) {//a为十进制数，n为进制数
        int sum = 0;
        while (a != 0) {
            sum += a % n;
            a = a / n;
        }
        return sum;
    }
}
