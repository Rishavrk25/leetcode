class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int arr[]:prerequisites){
            int u=arr[0];
            int v=arr[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.remove();
            list.add(u);
            for(int nei:adj.get(u)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        if(list.size()!=n) return new int[]{};
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
        
        

    }
}