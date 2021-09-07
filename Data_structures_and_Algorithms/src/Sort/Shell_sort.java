package Sort;

import java.util.Arrays;

/**
 * 希尔排序：高效版插入
 * @author luyao_start
 * @create 2021-08-24-19:46
 */
public class Shell_sort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);

    }

    public static void shellSort(int[] arr){
        //每一轮
        for (int gap = arr.length/2; gap > 0 ; gap /= 2) {

            //希尔
            for (int i = gap; i < arr.length ; i++) {
                //遍历组中元素
                for (int j = i-gap; j >= 0 ; j -= gap) {
                    if(arr[j] > arr[j+gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
