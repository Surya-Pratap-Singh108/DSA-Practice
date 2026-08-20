class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        int poped=-1;
        if(st1.isEmpty())return poped;
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        poped=st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return poped;
    }
    
    
    public int peek() {
        int peeked=-1;
        if(st1.isEmpty())return peeked;
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        peeked=st2.peek();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return peeked;
    }
    
    public boolean empty() {
        return st1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */