package Sort;

import java.util.Arrays;

/**
 * 快速排序:对冒泡的改进
 * @author luyao_start
 * @create 2021-08-25-9:48
 */
public class Quick_sort {

    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //pivot中轴
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while(l < r){
            //在pivot左边一直找，找到大于pivot的才退出
            while(arr[l] < pivot){
                l += 1;
            }
            while(arr[r] > pivot){
                r -= 1;
            }
            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r -= 1;
            }
            if(arr[r] == pivot){
                l += 1;
            }



        }

        if(l == r){
            l += 1;
            r -= 1;
        }
        if(left < r){
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }
    }
}
