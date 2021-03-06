package Design._232;

import java.util.Stack;

class MyQueue {

    Stack<Integer> tail;
    Stack<Integer> head;

    /** Initialize your data structure here. */
    public MyQueue() {
        tail = new Stack<>();
        head = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        tail.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!tail.isEmpty())
            head.push(tail.pop());

        int result = head.pop();

        while(!head.isEmpty())
            tail.push(head.pop());
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while(!tail.isEmpty())
            head.push(tail.pop());

        int result = head.peek();

        while(!head.isEmpty())
            tail.push(head.pop());
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return tail.isEmpty();
    }
}