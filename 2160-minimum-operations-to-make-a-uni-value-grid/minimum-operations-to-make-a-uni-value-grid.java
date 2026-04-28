class Solution {
    public int minOperations(int[][] grid, int x) {
        int m=grid.length;
        int n=grid[0].length;
        int arr[] = new int[m*n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid=m*n/2;
        int target = arr[mid];
        int ans=0;
        for(int i=0;i<m*n;i++){
            int diff = Math.abs(target-arr[i]);
            if(i==mid) continue;
            if(diff%x!=0) return -1;
            ans+=diff/x;
        }
        return ans;

    }
}