package com.csm.day02;

import java.lang.reflect.Array;

/**
 * @Author 快乐小柴
 * @Date 2022/10/6 10:20
 * @Version 1.0
 * 求一个局部最小
 */
//arr 整体

public class oneMinIndex {
    public static void main(String[] args) {
        int testTimes=10000;
        int maxLength=10;
        int maxValue=20;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr =creatRandomArray(maxLength,maxValue);
            int ans=oneMinIndex(arr);
            //如果检查不通过,就打印数组和找到的位置,break
            if (!check(arr,ans)){
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }
    //  arr可以无序
    //  arr相邻两个数之间不相等

    public static int oneMinIndex(int[] arr) {

        //边界情况
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
//        if (arr.length == 1) {
//            return 0;
//        }
//        if (arr.length == 2) {
//            return arr[0] > arr[1] ? 1 : 0;
//        }
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[N - 2] > arr[N - 1]) {
            return N - 1;
        }

        //其他情况，开始二分
        int L = 0;
        int R = N - 1;
        int ans = -1;
        while (L < R-1) {//当存在三个数及以上可以继续二分，当只有两个数时继续二分mid-1就会越界，在退出循环时
            int mid = (L + R) / 2;
            //如果中点位置找到了，返回
            //为什么没有等于号？因为条件就是相邻两个数必须无序
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }else {//1  左>我  我>右
                   //2  左<我  我<右
                   //3  左<我  我>右
                if (arr[mid]> arr[mid - 1]) {// 2 3
                    R=mid-1;//去右边找
                }else {//arr[mid]< arr[mid - 1] 1
                    L=mid+1;//去左边找
                }
            }

              //第二种理解
//            if (arr[mid]< arr[mid-1]&&arr[mid] < arr[mid+1]){
//                ans=mid;
//                break;
//
//            }else//因为一开始筛选了arr[0]<arr[1]的情况如果中点小于中点+1，左边曲线下降，右边曲线下降，必然存在局部最小
//                if(arr[mid] < arr[mid + 1]){
//                R=mid-1; //放弃右边的部分，[0,mid-1]区间上必然存在局部最小，继续二分
//                continue;
//            }else //因为一开始筛选了arr[N-2]>arr[N-1]的情况如果中点大于中点+1，左边曲线下降，右边曲线下降，必然存在局部最小
//                if (arr[mid] >arr[mid + 1]) {
//                L = mid+1;//不要右边的部分，[mid-1，N-1]区间上必然存在局部最小，继续二分
//                continue;
//            }
        }
        return arr[L]>arr[R]?R:L;
    }

    //生成一个随机的无序数组，保证相邻两个数不相等
    public static int[] creatRandomArray(int maxLength,int maxValue){
        int length = (int) (maxLength*Math.random());
        int[] arr=new int[length];
        if (length>0){
            arr[0]=(int) (maxValue*Math.random());
            for (int i = 1; i < length; i++) {
                do {
                    arr[i]=(int) (maxValue*Math.random());
                }while (arr[i]==arr[i-1]);//当相邻两个数相等时重做
            }
        }
        return arr;
    }

    //  对数器，用于比较测试
    public static boolean check(int[] arr,int minIndex){
        if (arr.length == 0){
            return minIndex==-1;
        }
        int left=minIndex-1;
        int right=minIndex+1;
        //如果越界则默认存在
        boolean leftBigger = left>=0 ? arr[left]>arr[minIndex]:true;
        //如果越界则默认存在
        boolean rightBigger = right<arr.length ? arr[right]>arr[minIndex]:true;
        return leftBigger&&rightBigger;
    }
    public static void printArray(int[] arr){
        for (int num:arr){
            System.out.print(num +" ");
        }
        System.out.println();
    }


}
