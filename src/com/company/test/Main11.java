package com.company.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 统计字符串出现次数
 */
public class Main11 {
    public static void main(String[] args) {
        String[] s = {"abc", "as", "hh", "as", "hh", "hello"};
        //统计个数
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length; i++) {
            int count = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[i].equals(s[j]))
                    count++;
            }
            map.put(s[i], count);
        }

        //方法1
        //去重
        String b[] = new String[s.length];
        int index = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!list.contains(s[i])) {
                list.add(s[i]);
                b[index] = s[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(b[i] + ":" + map.get(b[i]));
        }

//    //方法2
//        Iterator it =map.keySet().iterator();
//        String str;
//        while(it.hasNext()){
//            str=(String)it.next();
//            System.out.println(str+":" + map.get(str));
//        }
    }
}
