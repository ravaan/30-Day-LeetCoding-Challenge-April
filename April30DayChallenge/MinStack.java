class MinStack {
    Stack<Integer> s, m;
    /** initialize your data structure here. */
    public MinStack() {
        this.s = new Stack<Integer>();
        this.m = new Stack<Integer>();
    }

    public void push(int x) {
        s.push(x);
        if(!m.empty()){
            if(x <= m.peek()){
                m.push(x);
            }
        }
        else
            m.push(x);
    }

    public void pop() {
        int p = s.pop();
        if(m.peek() == p) m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */