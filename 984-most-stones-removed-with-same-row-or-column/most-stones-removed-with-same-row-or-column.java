class Solution {
    void dfs(int arr[][],boolean visited[],int u){
        visited[u]=true;
        int r=arr[u][0];
        int c=arr[u][1];
        for(int i=0;i<arr.length;i++){
            int nr=arr[i][0];
            int nc=arr[i][1];
            if(!visited[i] && (r==nr || c==nc)){
                dfs(arr,visited,i);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean visited[] = new boolean[n];
        int groups=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(stones,visited,i);
                groups++;
            }
        }
        return n-groups;
    }
}