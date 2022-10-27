package com.csm.day01;

/**
 * @Author 快乐小柴
 * @Date 2022/10/5 16:46
 * @Version 1.0
 * 求前缀和数组
 */
public class preSum {
    public static void main(String[] args) {

        int[] arr={1,3,5,7,8,6,15,4,32,45,10};

        int [] preSum =creatPreArr(arr);

        System.out.println(rangeSum(preSum,0,8));

    }
    //构建一个前缀和数组
    public static int[] creatPreArr(int[] arr){
        int N = arr.length;
        int[] preSum = new int[N];
        //边界
        preSum[0] = arr[0];
        //累计求和
        for (int i = 1; i < N; i++) {
            //
            preSum[i]=preSum[i-1]+arr[i];
        }
        return preSum;
    }

    /**
     *
     * @param preSum
     * @param L
     * @param R
     * @return
     * //求数组从[L，R]范围的和
     */

    public static int rangeSum(int[] preSum ,int L,int R){
        //如果开始范围是0开始，那么就直接返回preSum[R]，如果L不是0就返回preSum[R]-preSum[L]
        return L==0 ? preSum[R]:preSum[R]-preSum[L];
    }


}
