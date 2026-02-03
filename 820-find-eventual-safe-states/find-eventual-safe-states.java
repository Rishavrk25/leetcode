class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int u=graph[i][j];
                int v=i;
                adj.get(u).add(v);
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.remove();
            ans.add(u);
            for(int nei:adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        Collections.sort(ans);
        return ans;

    }
}