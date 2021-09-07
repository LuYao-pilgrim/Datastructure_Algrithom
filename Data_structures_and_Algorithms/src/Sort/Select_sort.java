package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 找最小，放到arr[0];循环n-1次;
 * @author luyao_start
 * @create 2021-08-22-9:52
 */
public class Select_sort {
    public static void main(String[] args) {
        int arr[] = {3,2,4,1,5};
        selectSort(arr);

    }

    public static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length-1; j++) {
            int minIndex = j;
            int min = arr[j];
            for (int i = j+1; i < arr.length; i++) {
                if(min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            //把最小值放在arr[0],交换
            if(minIndex != j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
