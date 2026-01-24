class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        List<Integer> nse = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) nse.add(0,n);
            else nse.add(0,st.peek());
            st.push(i);
        }
        st.clear();
        List<Integer> pse = new ArrayList<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) pse.add(-1);
            else pse.add(st.peek());
            st.push(i);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            int a = nse.get(i);
            int b = pse.get(i);
            int diff =  a-b-1;
            int area = diff * arr[i];
            ans = Math.max(ans,area);
        }
        return ans;
    }
}