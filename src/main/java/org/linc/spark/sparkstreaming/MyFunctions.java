package org.linc.spark.sparkstreaming;

/**
 * 用于测试的函数
 * Created by ihainan on 4/12/15.
 */
public class MyFunctions {
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static int addOne(Integer number) {
        int j=0;
        for(int i=0;i<1000;i++)
            j++;
        return number + 1;
    }
    public static int addTwo(Integer number) {
        int j=0,w=0;
        for(int i=0;i<1000;i++) {
            for (j = 0; j < 1000; j++) {
                w++;
            }
        }
        return number + 1;
    }

    public static int add(Integer number1, int number2) {
        return number1 + number2;
    }

    public static String add(String str1, String str2) {
        return str1 + " " + str2;
    }

    public static String add(Integer int1, String str2) {
        return int1 + " " + str2;
    }


    public static String getOriginalStr(String str) {
        return str;
    }

    public static String shaixuan(String str){return  str;}
}