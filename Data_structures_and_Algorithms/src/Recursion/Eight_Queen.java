package Recursion;

/**
 * 八皇后问题
 * @author luyao_start
 * @create 2021-08-20-10:06
 */
public class Eight_Queen {
    //定义一个MAX表示共有多少个皇后
    int MAX = 8;
    static int count = 0;
    int[] array = new int[MAX];
    public static void main(String[] args) {
        Eight_Queen eight_queen = new Eight_Queen();
        eight_queen.check(0);
        System.out.printf("一共有%d种解法",count);

    }
    //放置
    private void check(int n){
        if(n == MAX){//在放第9 个了！下标0开始
            print();//把这一种输出
            return;
        }
        for (int i = 0; i < MAX; i++) {
            //先把这个皇后，放在该行第一列
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }

        }
    }
    //查看当我们放置第n个皇后时候，检测是否有冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {//是否同一列，同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs((array[n]-array[i]))) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后摆放位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
    
}
