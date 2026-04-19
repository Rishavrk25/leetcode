class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int p[]:prerequisites){
            int u=p[1];
            int v=p[0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        int ans[] = new int[n];
        int k=0;
        int c=0;
        while(!q.isEmpty()){
            int u = q.remove();
            c++;
            ans[k++]=u;
            for(int nei:adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        if(c!=n) return new int[]{};
        return ans;
    }
}