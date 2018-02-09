package pers.vin.base.dataStructure;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Created by vin on 07/02/2018.
 */
public class QueueSample {

// thought and principle
// 队列是一种特殊的线性表,它只允许在表的前端进行删除操作,而在表的后端进行插入操作
// 队列是一种数据结果,他有两个基本操作:在队列尾部加入一个元素和从队列头部移除一个元素
// 0. like a array , but FIFO (first in first out) can image people in a queue to buy movie tickets

// step by step
// 1. initial , the queue initialize front = 0 , rear = -1 , size=0
// 2. insert , if there is only one element the front equals the rear
//    继续 insert 队列头保持不变,队列尾下表向后移动 , 队列大小 size 加1
// 3. remove , 只能从头部移除元素.这里不是移除而是把下标向前移动一位,丢弃数组中的元素.队列大小 size 减1
// 4. peekFront(), 拿到队列头元素, objQueue[front]  数组对象加当前头部记录的下标
// 5. peekRear(),  取尾部元素,同第四步
// 6. 当队列只有一位元素时,队列头 队列尾 指向同一数组下标,同一元素.
//    当初始第一个元素时,下标同为0 . 其他情况就是队列只有一个元素时,但各下标都有可能
// 7. 当size=10的时候,不可再insert; 当size=0的时候,不可再remove
// 8. 当rear=9,但队列为空时,rear继续从头开始(循环队列,不可插入为单项队列)


    public QueueSample() {

        // initialized
        front = 0;
        rear = -1;
        size = 0;
    }

    Object[] objQueue = new Object[10];

    // queue head
    int front;

    // queue foot
    int rear;

    // queue size
    int size;


    void insert(Object obj) {

        //队列满
        if (size == 10) {
            System.out.println("队列已满!");
            return;
        }

        if (size < 10) {
            //队列空,但rear已到尾部,rear从头开始,rear=0
            if (rear < 9) {
                rear++;
            } else {
                System.out.println("队列空,但rear已到尾部,rear从头开始,rear=0");
                rear = 0;
            }

            objQueue[rear] = obj;
            System.out.println("队列插入元素,rear后移一位" + obj);
        }

        size++;
    }

    void remove() {
        if (size < 0) {
            System.out.println("队列已空!");
            return;
        }

        if (size > 0) {
            System.out.println("队列移除删除,front先前移动一位");
            //队列空,但front已到尾部,front从头开始,front=0
            if (front < 9) {
                front++;
            } else {
                System.out.println("队列空,但front已到尾部,front从头开始,front=0");
                front = 0;
            }

        }
        size--;
    }

    Object peekFront() {

        if (size <= 0) {
            System.out.println("queue is empty!");
            return null;
        }

        return objQueue[front];
    }

    Object peekRear() {
        if (size <= 0) {
            System.out.println("queue is empty!");
            return null;
        }
        return objQueue[rear];
    }

    int getSize() {
        return size;
    }


    public static void main(String[] args) {

        myQueue();

        queueTest();

    }

    private static void myQueue() {
        String newLine = System.getProperty("line.separator");

        QueueSample queueSample = new QueueSample();

        System.out.println("=== the first element ===");
        queueSample.insert("vin");

        printIndex(queueSample);

        System.out.println(newLine + "=== insert element ===");
        queueSample.insert("bird");

        printIndex(queueSample);

        System.out.println(newLine + "=== remove element ===");
        queueSample.remove();

        printIndex(queueSample);

        for (int i = 0; i < 10; i++) {
            queueSample.insert(i);
        }

        queueSample.remove();
        queueSample.remove();
        queueSample.remove();

        for (int i = 0; i < 10; i++) {
            queueSample.insert(i);
        }

        System.out.println("此时队列" + Arrays.toString(queueSample.objQueue));

        printIndex(queueSample);
    }

    private static void printIndex(QueueSample queueSample) {
        System.out.println("front : " + queueSample.front + "=== my queue front  : " + queueSample.peekFront());
        System.out.println("rear : " + queueSample.rear + "=== my queue rear  : " + queueSample.peekRear());
        System.out.println("my queue size : " + queueSample.getSize());
    }


    static void queueTest() {

        Queue<String> queue = new LinkedList<String>();

        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        for (String q : queue) {
            // queue.remove(); //ConcurrentModificationException the same as linkList
        }

        System.out.println("queue peek() : " + queue.peek());//when queue empty return null
        System.out.println("queue peek() : " + queue.peek());
        System.out.println("queue element() : " + queue.element());//when queue empty throw exception
        System.out.println("queue element() : " + queue.element());


        System.out.println("==== ArrayQueue ===");

        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.add("vin");
        arrayQueue.add("ccc");

        Iterator iterator = arrayQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println("ArrayQueue iterator : " + iterator.next());
        }

        System.out.println(arrayQueue);


    }
}





