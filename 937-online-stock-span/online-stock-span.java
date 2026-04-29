class StockSpanner {
    Stack<Integer> st;
    List<Integer> list;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
        idx=0;
    }
    
    public int next(int price) {
        list.add(price);
        int ans=0;
        while(!st.isEmpty() && list.get(st.peek())<=list.get(idx)) st.pop();
        if(st.isEmpty()) ans=idx+1;
        else ans = idx-st.peek();
        st.push(idx);
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */