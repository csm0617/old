package com.csm.day02;

import java.util.Arrays;

/**
 * @Author 快乐小柴
 * @Date 2022/10/6 9:27
 * @Version 1.0
 * 二分查找<=num最右位置
 */
public class mostRightNoMoreNum {
    public static void main(String[] args) {
        //生成随机数组进行测试
        int testTimes=500000;
        int maxSize=10;
        int maxValue=100;
        boolean succeed =true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value = (maxValue+1) *(int) Math.random()-maxValue*(int) Math.random();
            if (test(arr,value)!=mostLeftNoLessNumIdx(arr,value)){
                succeed =false;
                break;
            }
        }
        System.out.println(succeed ? "nice!" :"fucking!");
    }

    //arr有序得,=<num最左。
    public static int mostLeftNoLessNumIdx(int[] arr, int num) {
        //边界情况
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid]<=num){
                //记录<=num的位置,但不一定是最右!!!还是要记录下位置，可能是最右
                ans=mid;
                L=mid+1;
            }else {//arr[mid]>num
                R=mid-1;
            }

        }
        //无论找没找到返回一个ans
        return ans;
    }

    //对数器
    public static int test (int[] arr,int value){
        for (int i = arr.length - 1; i >=0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return - 1;
    }

    //生成随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr =new int[(maxSize+1)*(int)Math.random()];
        for (int i = 0; i <arr.length; i++) {
            //[-maxValue-1,maxValue]
            arr[i] = (maxValue+1) * (int) Math.random() -maxValue*(int)Math.random();
        }
        return arr;
    }

}

