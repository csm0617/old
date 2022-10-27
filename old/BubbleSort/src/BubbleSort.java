public class BubbleSort {
    public static void main(String[] args) {
        MyTools mt = new MyTools();
        int[] arr = {15, 2, 33, 88, 5};
        mt.bubble(arr);
        System.out.println("排序后的数组为========");
        mt.printArr(arr);
    }
}


class MyTools {
    public void bubble(int[] arr) {//从小到大冒泡排序
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {//外层循环
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void printArr(int[] arr) {//打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}