package com.company.test;
/*
 * 瓶盖瓶子换啤酒经典问题
 * 啤酒A元一瓶，B个空盖可兑换一瓶，C个瓶子可兑换一瓶，请问D元钱总共能喝多少瓶？
 * 输入：
 * 4
 * 4
 * 2
 * 30
 * 输出：
 * 23
 */

import java.util.Scanner;

public class Main4 {
    private static int leftBottle;//剩余空瓶
    private static int leftTop;//剩余瓶盖
    private static int _price;//价格
    private static int _money;//总钱数
    private static int _cap;//瓶盖换瓶比
    private static int _emptyBottle;//空瓶换瓶比

    static int maxMount(int cap, int emptyBottle) {//瓶盖，空瓶
        if (emptyBottle >= _emptyBottle || cap >= _cap) {
            leftBottle = (emptyBottle / _emptyBottle) + (emptyBottle % _emptyBottle) + (cap / _cap);
            leftTop = (cap / _cap) + (cap % _cap) + (emptyBottle / _emptyBottle);
            return (emptyBottle / _emptyBottle) + (cap / _cap) + maxMount(leftTop, leftBottle);
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        _price = Integer.parseInt(in.nextLine().trim());
        _cap = Integer.parseInt(in.nextLine().trim());
        _emptyBottle = Integer.parseInt(in.nextLine().trim());
        _money = Integer.parseInt(in.nextLine().trim());

        res = _money / _price + maxMount(_money / _price, _money / _price);
        System.out.println(String.valueOf(res));

    }
}