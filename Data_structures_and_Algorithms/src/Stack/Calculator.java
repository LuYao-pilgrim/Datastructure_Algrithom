package Stack;

/**
 * @author luyao_start
 * @create 2021-08-19-10:37
 */
public class Calculator {
    public static void main(String[] args) {

    }
}

class ArrayStack2{
    private int maxSize;
    private int[] stack;//数组模拟栈
    private  int top = -1;//栈顶,初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        //先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        //先判断是否空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈(需要从栈顶开始显示)
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}

