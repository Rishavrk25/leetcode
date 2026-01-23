class Solution {
    public boolean canJump(int[] arr) {
        int n=arr.length;
        int maxIdx  = 0;
        for(int i=0;i<n;i++){
            if(maxIdx<i) return false;
            maxIdx = Math.max(maxIdx,i+arr[i]);
        }
        return true;
        
    }
}