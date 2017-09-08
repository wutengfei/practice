package com.company.others;

/**
 * Created by dell on 2016/10/14.
 */
 class UseStringBuffer {
    public static void main(String args[]){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("name");
        stringBuffer.append("\n");
        stringBuffer.append(true);
        stringBuffer.append("\n");
        stringBuffer.append('a');
        System.out.println(stringBuffer);

        stringBuffer.insert(2,"yes");
        System.out.println(stringBuffer);
    }
}
