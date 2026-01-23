class Solution {
    public boolean canJump(int[] arr) {
        // Brute Force
        int n=arr.length;
        if(n==1) return true;
        boolean iszero=false;
        for(int i=0;i<n-1;i++) if(arr[i]==0) iszero=true;
        if(!iszero) return true;
        for(int i=0;i<n-1;i++){
            if(arr[i]==0){
                boolean flag=false;
                for(int j=i-1;j>=0;j--){
                    if(j+arr[j]>i){
                        flag=true;
                        break;
                    }
                }
                if(!flag) return false;
            }
        }
        return true;

        // Greedy
        // int n=arr.length;
        // int maxIdx  = 0;
        // for(int i=0;i<n;i++){
        //     if(maxIdx<i) return false;
        //     maxIdx = Math.max(maxIdx,i+arr[i]);
        // }
        // return true;
        
    }
}