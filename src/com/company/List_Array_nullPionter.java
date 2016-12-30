package com.company;

import java.util.*;

/**
 * Created by dell on 2016/9/28.
 */
public class List_Array_nullPionter {
    public static void main(String[] args) {
        //定义数组、list、map，初始化为空
        String[] array = null;
        List<String> list = null;
        Map<String, Object> map = null;

        //创建数组、list、map对象
        String[] arraystr = new String[0];
        List<String> liststr = new ArrayList<String>();
        Map<String, Object> mapstr = new HashMap<String, Object>();

        System.out.println(array);
        System.out.println(list);
        System.out.println(map);

        System.out.println(arraystr);
        System.out.println(liststr);
        System.out.println(mapstr);

        //调用新建数组、list、map对象的length、size方法
        System.out.println(arraystr.length);
        System.out.println(liststr.size());
        System.out.println(mapstr.size());

        //判断是否为null
        System.out.println(array == null);
        System.out.println(list == null);
        System.out.println(map == null);

        //调用为null的数组、list、map的length、equals、size、isEmpty方法
        //以下全报空指针异常
        // System.out.println(array.length);
        //   System.out.println(list.size());
        // System.out.println(map.size());

        //  System.out.println(array.equals(null));
        // System.out.println(list.isEmpty());
        //System.out.println(map.isEmpty());


        int a = new Random().nextInt(3);//产生[0,3)之间的随机数(int型)
        System.out.println(a);
    }
}
