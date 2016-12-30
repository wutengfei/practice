package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by dell on 2016/9/22.
 * 输入一个手机号，生成一句宋词：输入11位手机号加上生成的一个随机数，组成6组双位数对应6个词。
 */
public class poem2 {
    public static void main(String[] args) {
        String[] words = new String[]{"东风", "何处", "人间", "风流", "归去", "春风", "西风", "归来",
                "江南", "相思", "梅花", "千里", "回首", "明月", "多少", "如今", "阑干", "年年", "万里",
                "一笑", "黄昏", "当年", "天涯", "相逢", "芳草", "尊前", "一枝", "风雨", "流水", "依旧",
                "风吹", "风月", "多情", "故人", "当时", "无人", "斜阳", "不知", "不见", "深处", "时节",
                "平生", "凄凉", "春色", "匆匆", "功名", "一点", "无限", "今日", "天上", "杨柳", "西湖",
                "桃花", "扁舟", "消息", "憔悴", "何事", "芙蓉", "神仙", "一片", "桃李", "人生", "十分",
                "心事", "黄花", "一声", "佳人", "长安", "东君", "断肠", "而今", "鸳鸯", "为谁", "十年",
                "去年", "少年", "海棠", "寂寞", "无情", "不是", "时候", "肠断", "富贵", "蓬莱", "昨夜",
                "行人", "今夜", "谁知", "不似", "江上", "悠悠", "几度", "青山", "何时", "天气", "惟有",
                "一曲", "月明", "往事","" };
        for (; ; ) {
            System.out.println("请输入手机号");
            Scanner sc = new Scanner(System.in);
            String telephoneNo = sc.next()+(int)Math.floor(Math.random()*10);//把输入的数字转换为字符串并在末尾加一个随机数
            String a[] = new String[6];//两位一截取存入新数组
            for (int i = 0; i < 12; i += 2) {
                    a[i / 2] = telephoneNo.charAt(i) + "" + telephoneNo.charAt(i + 1);
            }
            int b[] = new int[6];
            for (int i = 0; i < 6; i++) {
                b[i] = Integer.parseInt(a[i]);//字符串转为int
                // System.out.print(b[i]);
            }
            for (int i = 0; i < 6; i++) {
                if (i == 3) System.out.print(",");
                System.out.print(words[b[i]]);
            }
            System.out.println();
        }
    }
}
