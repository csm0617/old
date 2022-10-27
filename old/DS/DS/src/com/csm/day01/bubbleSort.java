package com.csm.day01;

/**
 * @Author 快乐小柴
 * @Date 2022/10/5 11:47
 * @Version 1.0
 * 冒泡排序
 */
public class bubbleSort {

    public static void main(String[] args) {
        int[] arr={7,28,6,9,67,745,15,65,84,2,11,3,58};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~n-1
        //0~n-2
        //0~n-3
        //0~1
        int N= arr.length;
        //第一个循环控制范围0~end
        for (int end=N-1; end>=0; end--) {
            //在0~end上做事情，
            //0 ~ 1 ，1 ~ 2，2 ~ 3 .....end-1 ~ end每一组的两个数换不换

            //第二个循环，比较每一组数据的大小，进行交换
            //每一组的第二个数开始，比如0 1，第二个数是1，一直到end
            for (int second = 1; second <= end; second++) {
                 if (arr[second]<arr[second-1]){
                     swap(arr,second,second-1);
                 }
            }

        }

    }
    //交换数组中的两个位置
    public static void swap(int[] arr ,int i , int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
