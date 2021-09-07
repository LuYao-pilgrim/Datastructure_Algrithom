package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 冒泡排序
 * @author luyao_start
 * @create 2021-08-21-15:17
 */
public class Bubble_sort {
    public static void main(String[] args) {
        int arr[] = {-3,1,3,-4,5,-10,30};
        //把最大的数放到末尾,共length-1次
        //可以看出时间复杂度:O(n^2)
        for (int j = 0; j < arr.length-1; j++) {
            int temp = 0;
            boolean flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i]>arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
            if(flag == false){
                break;
            }else{
                flag = false;
            }



        }

    }
}
