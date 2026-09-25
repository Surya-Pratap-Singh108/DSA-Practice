import java.util.Stack;

class MinStack {
    static class Pair {
        int val;
        int min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val)); // min = val
        } else {
            int currentMin = Math.min(val, stack.peek().min);
            stack.push(new Pair(val, currentMin));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */