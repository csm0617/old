package com.csm.day01;

/**
 * @Author 快乐小柴
 * @Date 2022/10/5 12:35
 * @Version 1.0
 * 插入排序
 */
public class insertSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 32, 21, 18, 9, 8, 72, 36, 213};
        printArray(arr);
//        insertSort(arr);
//        printArray(arr);
        System.out.println("===========方法二========");
        insertSort2(arr);
        printArray(arr);
    }

    public static void insertSort(int[] arr) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //0~0已完成
        //0-1
        //0~2
        //.....
        //0~n-1
        for (int end = 1; end < N; end++) {
            //每次插入新数前，把索引放在数组末尾
            int newNumberIndex = end;
            //当新数比前一个数小，进行交换，更新索引位置为前一个位置，循环判断，直到到达边界
            while (newNumberIndex - 1 >= 0 && arr[newNumberIndex] < arr[newNumberIndex - 1]) {
                swap(arr, newNumberIndex, newNumberIndex - 1);
                //不断将索引前移，循环比较
                newNumberIndex--;
            }
        }
    }
    //插入排序算法二
    public static void insertSort2(int[] arr){
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //0~0已完成
        //0-1
        //0~2
        //.....
        //0~n-1
        for (int end = 1; end < N; end++) {
            //pre表示插入数据的前一个数，pre+1表示要插入数据的当前位置pre<0时到达边界，pre--表示前移
            for (int pre=end-1; pre>=0&&arr[pre] > arr[pre+1]; pre--) {
                swap(arr,pre,pre+1);
            }
        }
    }

}
