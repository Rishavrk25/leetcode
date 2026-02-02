class Solution {
    boolean dfs(int graph[][],int color[],int i){
        // color[i]=0;
        for(int nei : graph[i]){
            if(color[nei]==-1){
                color[nei] = 1-color[i];
                if(!dfs(graph,color,nei)) return false;
            }
            else if(color[nei]==color[i]) return false;
        }
        return true;
    }
    // boolean bfs(int graph[][],int color[],int i){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(i);
    //     color[0]=0;
    //     while(!q.isEmpty()){
    //         int u=q.remove();
    //         for(int nei : graph[u]){
    //             if(color[nei]==-1){
    //                 color[nei] = 1 - color[u];
    //                 q.add(nei);
    //             }
    //             else{
    //                 if(color[nei]==color[u]) return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                // if(!bfs(graph,color,i)) return false;
                if(!dfs(graph,color,i)) return false;
            }
        }
        return true;

    }
}