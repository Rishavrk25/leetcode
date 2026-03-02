class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int trailingZeros[] = new int[n]; // store count of trailing zeros of each row
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0) c++;
                else break;
            }
            trailingZeros[i]=c;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int need = n-i-1;
            int idx = -1; // index of row with zeros >= need
            for(int j=i;j<n;j++){
                if(trailingZeros[j] >= need){
                    ans+=j-i;
                    idx=j;
                    break;
                }
            }
            if(idx==-1) return -1;
            for(int j=idx;j>0;j--){
                int t = trailingZeros[j];
                trailingZeros[j]=trailingZeros[j-1];
                trailingZeros[j-1]=t;
            }
        }
        return ans;
    }
}