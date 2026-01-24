class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int ele = nums2[i];
            while(!st.isEmpty() && st.peek()<=ele) st.pop();
            if(st.isEmpty()) map.put(ele,-1);
            else map.put(ele,st.peek());
            st.push(ele);
        }
        int ans[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}