package com.csm.day01;

/**
 * @Author 快乐小柴
 * @Date 2022/10/5 17:09
 * @Version 1.0
 */
public class MathRandom {
    public static void main(String[] args) {

        System.out.println("测试开始");


        /* Math.random()  随机等概率返回一个double（计算机中的小数是有精度的，无法表示全部小数）
           Math.random()  产生随机数的范围是[0,1),！！！！左闭右开
        */
        int testTimes = 100000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.6) {
                count++;
            }
        }

        System.out.println((double) count / testTimes);

        //[0,1)  ->[0,9)
        System.out.println("====================");
        int K = 9;
        int[] counts = new int[K];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }

        System.out.println("==================");
        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            //只有当两次产生的随机数都小于0.7时，count才会计数也就是  0.7*0.7 == power(0.7,2)
            if (xToXPower2() < x) {
                count++;
            }
        }

        System.out.println((double) count / testTimes);
        System.out.println(Math.pow(x, 2));

        System.out.println("===================");

        count = 0;
        x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower3() < x) {
                count++;
            }
        }

        System.out.println((double) count / testTimes);
        System.out.println(Math.pow(x, 3));

        System.out.println("=======================");

        System.out.println(f3());

        System.out.println("=======================");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num=f3();
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i+"出现了"+counts[i]+"次");
        }

    }
    //返回[0,1)的一个小数
    //任意的x,x属于[0，1)，[0,x)范围上的数出现的概率由原来的x调整成x的平方

    public static double xToXPower2() {
        //返回两次产生随机数的情况
        return Math.max(Math.random(), Math.random());
    }

    //返回[0,1)的一个小数
    //任意的x,x属于[0，1)，[0,x)范围上的数出现的概率由原来的x调整成x的三次方
    //和二次方同理

    public static double xToXPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    //返回一个[0,4)的随机数
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    //构造0 ，1等概率生成器
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 随机生成一个[0,7]的整数
    public static int f3() {
        //利用生成的0，1 得到二进制位进行左右移动

        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }
}
