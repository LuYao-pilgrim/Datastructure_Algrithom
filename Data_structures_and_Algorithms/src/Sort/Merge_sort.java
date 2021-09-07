package Sort;

import java.util.Arrays;

/**
 * @author luyao_start
 * @create 2021-08-30-9:24
 */
public class Merge_sort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);

        System.out.println(Arrays.toString(arr));

    }

    //分+合，递归
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            //左递归
            mergeSort(arr, left, mid, temp);
            //右递归
            mergeSort(arr, mid+1, right, temp);
            //
            merge(arr, left, mid, right, temp);
        }
    }

    //合并
    public static void merge(int[] arr, int left, int mid ,int right, int[] temp){
        int i = left;//左索引
        int j = mid+1;//右索引
        int t = 0;//temp索引
        //把左右数据按照顺序填充到temp数组
        //直到一边填充完毕
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int templeft = left;
        while(templeft <= right){
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }

    }

}
