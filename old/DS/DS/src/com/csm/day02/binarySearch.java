package com.csm.day02;

import java.util.Arrays;

/**
 * @Author 快乐小柴
 * @Date 2022/10/6 8:40
 * @Version 1.0
 * 二分查找
 */
public class binarySearch {
    public static void main(String[] args) {

//        int [] arr={1,4,5,5,6,8,11,12,16,19,22,};
//        System.out.println(find(arr,18));
//        System.out.println(test(arr,18));
        //生成随机数组进行测试
        int testTimes=50000;
        int maxSize=10;
        int maxValue=100;
        boolean succeed =true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize,maxValue);
            Arrays.sort(arr);
            int value = (maxValue+1) *(int) Math.random()-maxValue*(int) Math.random();
            if (test(arr,value)!=find(arr,value)){
                succeed =false;
                break;
            }
        }
        System.out.println(succeed ? "nice!" :"fucking!");
    }

    //arr保证数组有序
    public static boolean find(int[] arr, int num) {
        //边界条件
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        //当索引左侧大于右侧时退出循环
        while (L <= R) {
        //上中点
            int mid =(L+R)/2;
        //找到返回
            if (arr[mid]==num){
                return true;
            }else if (arr[mid]<num){
                //当数在中点右侧，更新左侧索引
                L=mid+1;
            }else {
                //当数在中点左侧，更新右侧侧索引
                R=mid-1;
            }
        }
        return false;
    }
    //对数器
    public static boolean test(int[] sortedArray,int num){
        for (int i = 0; i < sortedArray.length; i++) {
            if(sortedArray[i]==num){
                return true;
            }
        }
        return false;
    }
    //生成随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr =new int[(maxSize+1)*(int)Math.random()];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = (maxValue+1) * (int) Math.random() -maxValue*(int)Math.random();
        }
        return arr;
    }


}
