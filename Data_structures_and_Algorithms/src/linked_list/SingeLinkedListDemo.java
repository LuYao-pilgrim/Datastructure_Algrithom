package linked_list;

/**
 * 单链表学习：水浒英雄列举(crud)
 * @author luyao_start
 * @create 2021-08-17-10:24
 */
public class SingeLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"公孙胜","入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");



        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.list();

        //反转测试
        System.out.println("**********反转**********");
        singleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();



    }



}
//定义一个SingleLinkedList,单链表放英雄
class SingleLinkedList{
    //初始化一个head节点
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //退出while循环时，temp指向末尾
        temp.next = heroNode;
    }

    //根据排名添加进去
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean isExit = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                isExit = true;
                break;
            }
            temp = temp.next;
        }
        if(isExit){
            System.out.println("该位置有人了");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示链表(遍历)
    public void list() {
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //单链表反转
    public void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        //定义一个辅助变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");

        while(cur != null){
            next = cur.next;//暂时储存
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }


}

//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//这玩意重要啊

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}
