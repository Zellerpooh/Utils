package com.zellerpooh.utils;

import java.math.BigDecimal;

/**
 *
 * 以BigDecimal为基础,实现double类型的经度不丢失运算
 * Created by Zellerpooh on 16/7/14.
 */
public class Arith {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE=10;
    //private构造方法,不允许外部进行实例化
    private Arith(){}
    //加法
    public static double add(double v1,double v2){
        BigDecimal b1=BigDecimal.valueOf(v1);
        BigDecimal b2=BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }
    //减法
    public static double sub(double v1,double v2){
        BigDecimal b1=BigDecimal.valueOf(v1);
        BigDecimal b2=BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    //乘法
    public static double mul(double v1,double v2){
        BigDecimal b1=BigDecimal.valueOf(v1);
        BigDecimal b2=BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }
    public static double div(double v1,double v2){
        BigDecimal b1=BigDecimal.valueOf(v1);
        BigDecimal b2=BigDecimal.valueOf(v2);
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }




}
