package com.company.others;


public class incrementCompare {
    /**
     * 本金0.3n，贷款0.7n，房价n
     *
     * @param args
     */
    public static void main(String[] args) {
        double m = 0.049 / 12;//月利率
        double p;//买房N年后拥有财富
        double y = 10;//贷款年限
        double i = 0.08;//房价年增长率
        double v;//投入资金
        p = Math.pow(1 + i, y);//(1+i)^y
        v = 0.3 + 12 * y * 0.7 * m * Math.pow(1 + m, 12 * y) / (Math.pow(1 + m, 12 * y) - 1);
        System.out.println("假设房价年增长率=" + i);
        System.out.println("买房"+(int)y+"年后拥有财富=" + p);
        System.out.println("总投入资金=" + v);
        System.out.println("资金增长为=" + p / v);
        System.out.println("资金增长率=" + (p - v) / v);

        System.out.println();

        double q;//理财N年后拥有财富
        double t=0.1;//理财年收益率
        q=0.3*Math.pow(1+t,y)+(12+t)/t*0.7*m*Math.pow(1+m,12*y)/(Math.pow(1+m,12*y)-1)*(Math.pow(1+t/12,12*y)-1);
        System.out.println("假设理财年收益率=" + t);
        System.out.println("理财"+(int)y+"年后拥有财富=" + q);
        System.out.println("总投入资金=" + v);
        System.out.println("资金增长为=" + q / v);
        System.out.println("资金增长率=" + (q - v) / v);
    }
}
