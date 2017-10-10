package com.company.test;

/**
 * 题目：一百瓶无色无味的药水，其中有一瓶毒药，7只小白鼠拿过来做实验，喝了无毒的药水第二天没事儿，喝了有毒的药水后第二天会死亡。
 * 如何在一天之内找出这瓶有毒的药水？
 * <p>
 * 题目变形：有N瓶水，其中有一瓶水有剧毒，如果小白鼠喝了会在一天内死亡，想在一天内找出哪瓶有毒，最少需要几只小白鼠
 * 答案：可通过二进制匹配计算 。   2^M >= N 计算出所需要的小白鼠的数量M即可
 * 对药水瓶进行二进制编号，并且让小白鼠按位去喝药水（遇见1喝，遇见0不喝）
 * http://www.cnblogs.com/mingmingruyuedlut/archive/2011/10/14/2211237.html
 */
public class LittleMouse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int start = 1;
        for (int i = 0; i < 100; i++) {
            String binaryStr = Integer.toBinaryString(start);
            binaryStr = addToTenStrWithZero(binaryStr);
            System.out.println("【  二进制映射喝法：" + binaryStr + "\t对应十进制编号第" + start
                    + "瓶药水  】");
            start++;
        }
    }

    public static String addToTenStrWithZero(String str) {
        if (str.length() != 7) {
            // 不够十位，进行0补全  
            int toAddCounter = 7 - str.length();
            for (int i = 0; i < toAddCounter; i++) {
                str = "0" + str;
            }
        }
        return str;
    }

}  