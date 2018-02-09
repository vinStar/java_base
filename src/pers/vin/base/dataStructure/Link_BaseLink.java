package pers.vin.base.dataStructure;


/**
 * Created by vin on 09/02/2018.
 */
public class Link_BaseLink {

    //thought and principle
    //1. 链表是一种物理存储单元上非连续,非顺序的存储结果（物理存储结构上不连续，逻辑上连续；大小不固定）
    //2. 数据元素的逻辑顺序是通过链表中的指针链接次序实现的
    //3. 链表由一系列节点(链表中每一个元素成为一个节点)组成,节点可以在运行时动态生成
    //4. 每个节点包括两个部分:一个是存储数据元素的数据域,另一个是存储下一个节点地址的指针域
    //5. 相比线性表顺序结构,操作复杂.由于不必按顺序存储,链表在插入的时候可以达到O(1)的复杂度,较快速
    //6. 但是查找一个节点或者访问特定编号的节点则需要O(n)的时间，而线性表和顺序表相应的时间复杂度分别是O(logn)和O(1)。

    //优点:
    //使用链表结构可以克服数组链表需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。
    //常规数组排列关联项目的方式可能不同于这些数据项目在记忆体或磁盘上顺序，数据的存取往往要在不同的排列顺序中转换。
    //链表允许插入和移除表上任意位置上的节点，但是不允许随机存取。
    //缺点:
    //链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大

    //链表类型:
    //面向对象,从现实世界找例子.比如火车,火车车厢的设计模式,对车厢进行动态挂在.每节车厢只保存一个数据.
    //单向链表---链表的每个结点中只包含一个指针域，叫做单链表（即构成链表的每个结点只有一个指向直接后继结点的指针）
    //单链表有带头结点结构和不带头结点结构两种。
    //    “链表中第一个结点的存储位置叫做头指针”，如果链表有头结点，那么头指针就是指向头结点的指针。
    //
    //    头指针所指的不存放数据元素的第一个结点称作头结点（头结点指向首元结点）。头结点的数据域一般不放数据（当然有些情况下也可存放链表的长度、用做监视哨等）
    //
    //    存放第一个数据元素的结点称作第一个数据元素结点，或称首元结点。
    //双向链表
    //循环链表。

    //step by step
    // 1. 定义节点,他有两个属性 (指向下一节点的指针,存储数据元素) ,能有多个属性的就是类了.
    // 4. 第一个节点如何插入? 定义一个空节点接收第一个node对象 怎么知道是第一个节点? 定义一个节点记录器.
    // 硬给自己提问题....
    // 5. 继续添加节点,修改firstNode指针指向第二个Node,第二个Node指针指向自己...节点记录器加1
    // 6. 添加完了就是删除


    //打印链表所有节点
    void print(Node node) {

        if (node != null) {//条件
            System.out.println(node.getData());
            print(node.getNext());  //自己调用自己
        }

    }


    public static void main(String[] args) {

        Link_BaseLink linkBaseLink = new Link_BaseLink();
        linkBaseLink.TestNode();
    }

    void TestNode() {

        //定义几个节点
        Node node0 = new Node("火车头");
        Node node1 = new Node("第一节车厢");
        Node node2 = new Node("第二节车厢");
        Node node3 = new Node("第三节车厢");

        //定义火车车厢(节点)之间的关联方式, 像火车车厢一样链接起来
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        //查找数据 递归(调用自己+结束条件)
        print(node0);

    }

    // 火车 车厢
    // 保存数据,确认先后顺序,链接节点
    class Node {

        //存储下一车厢
        Node next;
        //存储数据
        Object data;

        public Node(Object data) {//车厢里一定保存有数据
            this.data = data;
        }

        //可以修改当前node
        private void setNext(Node next) {
            this.next = next;
        }

        private void setData(Object data) {
            this.data = data;
        }

        //可以拿到Node信息
        private Node getNext() {
            return this.next;
        }

        private Object getData() {
            return this.data;
        }

    }


}
