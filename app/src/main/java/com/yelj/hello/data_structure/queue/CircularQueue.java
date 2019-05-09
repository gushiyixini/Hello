package com.yelj.hello.data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Alex.ylj
 * 2019/4/10 18:31 Wednesday
 * Description: 循环队列
 * https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/866/
 */
public class CircularQueue {

    private int[] data;
    private int start;
    private int end;
    private int size;

    /**
     * 使用一个数组和两个指针（start和end），分别标记队列的起始位置和结束位置
     */
    public CircularQueue(int size) {
        data = new int[size];
        start = -1;
        end = -1;
        this.size = size;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        //如果队列已满，则返回false
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            start = 0;
        }
        end = (end + 1) % size;
        data[end] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (start == end) {
            start = -1;
            end = -1;
            return false;
        }
        start = (start + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[start];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return start == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (end + 1) % size == start;
    }

    /**
     * java内置的队列库的应用
     * @see LinkedList
     * 获取第一个元素的值 q.peek()
     * 添加元素到队列 q.offer("a")
     * 第一个元素出队 q.poll()
     */
    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList<>();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
