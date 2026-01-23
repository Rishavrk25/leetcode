class Solution {
    // void dfs(List<List<Integer>> adj,int indegree[],boolean visited[],int i){
    //     visited[i]=true;
    //     for(int nei: adj.get(i)){
    //         indegree[nei]++;
    //         if(!visited[nei]) dfs(adj,indegree,visited,nei);
    //     }
    // }
    void bfs(List<List<Integer>> adj , int indegree[],boolean visited[],int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i]=true;
        while(!q.isEmpty()){
            int u = q.remove();
            for(int nei:adj.get(u)){
                indegree[nei]++;
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei]=true;
                }
            }
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
        }
        int indegree[] = new int[n];
        boolean visited[] = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            // dfs(adj,indegree,visited,i);
            if(!visited[i]) bfs(adj,indegree,visited,i);
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0) ans.add(i);
        }
        return ans;
    }
}