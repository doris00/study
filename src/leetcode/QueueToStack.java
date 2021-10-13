package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//225两个队列实现栈
public class QueueToStack {
    private Queue queue1;
    private Queue queue2;

    public QueueToStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }
    }

    public int pop() {
        return (int) queue1.poll();
    }

    public int top() {
        return (int) queue1.peek();
    }
    public boolean empty() {
        return queue1.isEmpty();
    }
}
