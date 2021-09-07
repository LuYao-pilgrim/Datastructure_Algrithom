package Sort;

import java.util.Arrays;

/**
 * 插入排序：
 * 有序表+无序表(1,2,3...)，每次无序表中拿出一个插入到有序表中
 * 缺点:插入的数较小时，后移次数增多，对效率有影响
 * @author luyao_start
 * @create 2021-08-23-10:36
 */
public class Insert_sort {
    public static void main(String[] args) {
        int arr[] = {101,34,119,1};
        insertSort(arr);
    }

    public  static void insertSort(int arr[]){
        //第一轮{101}有序表=>{34,101,119,1}
        for (int i = 1; i < arr.length; i++) {

            int insertVal = arr[i];
            int index = i-1;

            while(index >= 0 && insertVal < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = insertVal;
        }

        System.out.println(Arrays.toString(arr));


    }

}
