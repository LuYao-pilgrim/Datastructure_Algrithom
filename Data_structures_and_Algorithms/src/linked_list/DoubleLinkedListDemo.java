package linked_list;

/**
 * @author luyao_start
 * @create 2021-08-18-10:57
 */
public class DoubleLinkedListDemo {
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    //遍历
    public void list2() {
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //添加节点
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        //遍历
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //退出while循环时，temp指向末尾
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改节点内容
    public void update(HeroNode2 heroNode2){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点位置
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == heroNode2.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;
        }else{
            System.out.printf("没有找到编号为%d的节点，不能修改\n",heroNode2.no);
        }
    }

    //删除节点
    public void del(int no){
        HeroNode2 temp = head;
        boolean isFind = false;
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if(isFind){
            temp.next.pre = temp.pre;
            if(temp.next != null) {
                temp.pre.next = temp.next;
            }
        }else{
            System.out.printf("没有找到编号为%d的节点",no);
        }
    }

}

//定义一个HeroNode,每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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
