package com.company.basic.LinkedListDemo;
/*
<整理资料>
    Q：什么是头结点？
    A：数据结构中，在单链表的开始结点之前附设一个类型相同的结点，称之为头结点。头结点的数据域可以不存储任何信息，
    头结点的指针域存储指向开始结点的指针（即第一个元素结点的存储位置）。
    A：头结点其实就是一个数据域为空的结点（当然也可储存链表的长度之类的数据，一般对链表操作无影响），
    而首元结点就是第一个元素结点，即头结点后边的第一个结点。

    Q：用来干嘛？
    A：
    1、防止单链表是空的而设的。当链表为空的时候,带头结点的头指针就指向头结点。如果当链表为空的时候,
    单链表没有带头结点,那么它的头指针就为NULL。
    2、在第一个元素结点前插入结点（或删除第一个结点），使其操作与对其它结点一致。带头结点时，
    不论删除哪个位置上的结点，用到的代码都一样；不带头结点时，删除第1个元素和删除其它位置上的元素用到的代码不同，
    相对比较麻烦。
 */
public class SingleLInkedList {
    private HeroNode headNode = new HeroNode(3,"林冲","豹子头");//头节点,头节点相当于变量地址
    public HeroNode getHeadNode() {
        return headNode;
    }

    public void delete(int age){//删除节点，找到前一个节点
        //根据年龄删除人
        //辅助节点
        HeroNode temp = headNode;
        boolean flag = false;//判断有没有找到
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.next.age == age){//找到位置了
                flag = true;
                break;

            }

            temp = temp.next;//没找到就继续往下走
        }

        if(flag){
            temp.next = temp.next.next;
        }
        else
            System.out.println("我们没找到");

    }

    //添加节点到单向列表
    //找到当前链表，最后一个节点
    //将next指向最后一个节点
    public void add(HeroNode heroNode){
        HeroNode temp = headNode;//一个头指针
        while(true){//从头指针开始遍历
            if(temp.next == null ){
                break;
            }

            else
                temp = temp.next;
            //由于没有尾指针的概念，所以JAVA中链表，都是从头开始遍历，去找尾指针的
        }

        //将尾指针和后面连接起来
        temp.next = heroNode;

    }

    public void show(){//显示链表
        //需要辅助变量来遍历整个链表
        //先判断链表是否为空
        if(headNode == null){
            System.out.println("链表为空你个傻逼");

        }

        else{
            HeroNode temp = headNode.next;//从头节点的尾巴开始遍历
            while(temp != null){
                System.out.println(temp);//这里已经重写了toString方法
                temp = temp.next;//指针后移
            }
        }

    }

    /*
    添加一个变量进来，先找到变量添加位置的前一个节点，
    断开添加位置的连接
    然后插入完成
     */
    public void insert(HeroNode heroNode){
        HeroNode temp = headNode;
        while(true){//寻找插入的位置
            if(temp.next == null){
                break;
            }

            if (temp.next.age > heroNode.age){//位置找到了，找到正确添加排名的位置了
                break;//

            }
            else if(temp.next.age == heroNode.age){//说明要插入的位置查重复了
                System.out.println("你插入重复了");
                break;
            }

            temp = temp.next;
        }

        heroNode.next = temp.next;//给插上，先把尾巴接好，再去接头，接头接活过来了
        temp.next = heroNode;

    }

    //根据年龄来对人物进行姓名和昵称的修改，对链表进行增删改查

    public void update(HeroNode newHeroNode){
        if(headNode.next == null){//先进行判空
            System.out.println("链表为空");
            return;

        }

        HeroNode temp = headNode;//熟悉的从头节点开始遍历的环节
        //按照年龄找到需要修改的节点
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//到链表的最后啦，我没找到

            }
            if (newHeroNode.age == newHeroNode.age){
                flag = true;//这个要放在break之前,说明我找到了，而不是没找到

                break;           //说明你找到

            }

        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }
        else
            System.out.println("没有找到这个编号，你是不是傻了");

    }

    public static void main(String[] args) {
       SingleLInkedList singleLInkedList = new SingleLInkedList();
        singleLInkedList.add(new HeroNode(22,"吴用","智多星"));
        singleLInkedList.add(new HeroNode(23,"盖伦","德玛西亚之力"));
        singleLInkedList.add(new HeroNode(25,"李逵","黑旋风"));
        singleLInkedList.add(new HeroNode(29,"赵信","德邦"));
        singleLInkedList.delete(22);
    }

}

