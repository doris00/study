package leetcode;

import java.util.Deque;
import java.util.LinkedList;

//两个栈实现一个队列
public class StackToQueue {
    Object o = new Object();
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    public StackToQueue(){
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int x) {
        s1.push(x);
    }

    public int deletHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        } else {
            int x = s2.pop();
            return x;
        }
    }
}
