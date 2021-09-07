package linked_list;

/**
 * @author luyao_start
 * @create 2021-08-18-15:55
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showboy();
        System.out.println("*************************");
        //测试一把出圈
        circleSingleLinkedList.countBoy(1,2,5);
    }

}

//创建环形单向链表
class CircleSingleLinkedList{
    //创建一个first节点，没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建环形链表
    public void addBoy(int num){
        //num数据校验
        if(num < 1){
            System.out.println("num值不正确");
            return;
        }
        Boy curBoy = null;
        //使用循环创建
        for (int i = 1; i <= num; i++) {
            //根据编号创建
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                curBoy = boy;
                curBoy.setNext(first);

            }
        }
    }

    //遍历
    public void showboy(){
        if(first == null){
            System.out.println("没有小孩");
            return;
        }
        Boy curboy = first;
        while (true){
            System.out.printf("小孩编号为%d\n",curboy.getNo());
            if(curboy.getNext() == first){//说明遍历完毕
                break;
            }
            curboy = curboy.getNext();
        }
    }
    //根据用户输入，出圈顺序（约瑟夫问题）
    public void countBoy(int startno, int countnum, int nums){
        if(first == null || startno < 1 || startno > nums){
            System.out.println("参数有问题");
            return;
        }
        Boy helper = first;
        //让helper去指向最后一个
        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startno-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true){
            if(helper == first){
                break;
            }
            for (int i = 0; i < countnum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时，first指向的是要出圈的小孩
            System.out.printf("小孩%d出圈\n",first.getNo());
            //让他滚出去
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后在圈中的小孩编号是%d\n",first.getNo());

    }
}

//Boy类表示节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
