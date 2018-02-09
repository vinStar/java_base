package pers.vin.base.dataStructure;

/**
 * Created by vin on 09/02/2018.
 */
public class Link_PackageLink {


    public static void main(String[] args) {

    }

    class Link {

        private Node nodeHead;//必须要有火车头,没有根节点,就没有后续数据的保存

        class Node {

            Node next;

            Object data;

            public Node(Object data) {
                this.data = data;
            }


            //第一次调用:this = Link.nodeHead
            //第二次调用:this = Link.nodeHead.next
            //第三次调用:this = Link.nodeHead.next.next
            public void addNode(Node node) {
                if (this.next == null) {
                    this.next = node;
                } else { // 当前节点的下一个
                    this.next.addNode(node);
                }
            }

        }
        /*==================以下为Link类 =============*/

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

        }
    }

}
