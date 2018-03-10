package pers.vin.base.dataStructure;

/**
 * Created by vin on 09/02/2018.
 */
public class Link_PackageLink {


    public static void main(String[] args) {

        Link_PackageLink link = new Link_PackageLink();
        link.testLink();

    }

    void testLink() {

        // queue add
        Link link = new Link();
        link.add("node 1");
        link.add("node 2");
        System.out.println("link count : " + link.count);

        // convert queue to array
        Object[] desArray = link.toArray();
        for (int i = 0; i < desArray.length; i++) {
            System.out.println(desArray[i]);
        }


    }

    class Link {

        private int foot = 0; // 数组下标
        private Object[] retArray; //输出的数组对象

        private int count = 0; //node counter
        private Node nodeHead;//必须要有火车头,没有根节点,就没有后续数据的保存

        // 数据不分先后, 封装确定前后关系
        class Node {

            Node next;

            Object data;

            public Node(Object data) {
                this.data = data;
            }


            // 最后指针为null,可加下一节点(车厢)

            //第一次调用:this = Link.nodeHead
            //第二次调用:this = Link.nodeHead.next
            //第三次调用:this = Link.nodeHead.next.next
            //...
            public void addNode(Node node) {
                if (this.next == null) {
                    this.next = node;
                } else { // 当前节点的下一个
                    this.next.addNode(node);
                }
            }


            //第一次调用this=nodeHead
            //第二次调用this=nodeHead.next
            //第三次调用this=nodeHead.next.next
            //...

            public Object[] toArray() {
                retArray[Link.this.foot++] = this.data;
                if (this.next != null) {
                    //retArray[Link.this.foot++] = this.next.data;
                    this.next.toArray();
                }

                return retArray;
            }

        }
        /*==================以下为Link类 =============*/

        //add node
        public void add(Object data) {
            if (data == null) {//不允许数据为null,数据为空,直接返回
                return;
            }

            Node node = new Node(data);

            //第一个节点为空则赋值给根节点,第一节车厢就是过车头
            if (this.nodeHead == null) {
                this.nodeHead = node;
            } else {
                //第二节点先后添加,添加在火车头后边
                this.nodeHead.addNode(node);
            }

            this.count++;
        }

        //get node size
        public int getCount() {
            return count;
        }

        //to array
        public Object[] toArray() {
            if (this.count == 0) {
                return null;
            }

            //有数据开辟数组
            retArray = new Object[this.count];
            this.foot = 0;

            return this.nodeHead.toArray();
        }

    }
}
