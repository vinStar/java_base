package pers.vin.base.dataStructure;


import java.util.Arrays;

/**
 * Created by vin on 07/02/2018.
 */
public class QueueSample {

// thought and principle
// 0. like a array , but FIFO (first in first out) can image people in a queue to buy movie tickets
// 1. the first element in the queue is the front equals the rear
// 2. insert, 尾部插入,插入后rear后移
// 3. remove, when remove element from front the front move back and 原位置为空
// 4. 尾部满后, 队列不满,尾部移动到队头没有占用的位置

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
// 8. 当rear=10,但队列为空时,rear继续从头开始


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
        return objQueue[front];
    }

    Object peekRear() {
        return objQueue[rear];
    }

    int getSize() {
        return size;
    }


    public static void main(String[] args) {

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

        queueSample.remove();queueSample.remove();queueSample.remove();

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
}





