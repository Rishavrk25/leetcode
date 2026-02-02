class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int arr[] : prerequisites){
            int u=arr[0];
            int v=arr[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int u=q.remove();
            c++;
            for(int nei:adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        if(c==n) return true;
        else return false;
    }
}