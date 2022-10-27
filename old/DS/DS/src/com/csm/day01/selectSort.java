package com.csm.day01;

import com.sun.javafx.util.TempState;

/**
 * @Author 快乐小柴
 * @Date 2022/10/5 11:15
 * @Version 1.0
 *选择排序
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 5, 6, 8, 72, 35, 25};
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }

    public static void selectSort(int[] arr) {
        //边界条件，如果数组为空，或者数组只有一个元素，直接返回
        if (arr == null||arr.length< 2 ) {
            return;
        }
        //
        int N=arr.length;
        //1.   0 ~ n-1区间上,第一个循环控制区间 0~n-1 ,1~n-1,....,n-2~n-1.
        for (int i = 0; i < N; i++) {
            //第一次把开始位置设置为最小值，后面更新最小值的位置
            int minValueIndex=i;
            //2.     第二个循环找到最小值所在位置
            for (int j = i+1; j < N; j++) {
                //更新最小值所在位置，如果j所在位置小于最小值所在位置就更新，否则就不更新，
               minValueIndex = arr[j]>arr[minValueIndex] ? minValueIndex : j;
            }
            //3.   找到最小值所在的位置和i进行交换
            swap(arr,i,minValueIndex);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr ,int i , int j){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
}
