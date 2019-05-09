package com.yelj.hello.data_structure.queue;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Alex.ylj
 * 2019/4/10 16:35 Wednesday
 * Description: 队列练习
 */
class QueueTest {
    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int p_start;

    public QueueTest() {
        data = new ArrayList<>();
        p_start = 0;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        p_start++;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return data.get(p_start);
    }

    /**
     * Checks whether the queue is empty or not.
     */
    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public static void main(String[] args) {
        QueueTest q = new QueueTest();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }
}
