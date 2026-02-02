class Solution {
    boolean isCycle(List<List<Integer>> adj,int i,boolean visited[],boolean inRecursion[]){
        visited[i]=true;
        inRecursion[i]=true;
        for(int nei:adj.get(i)){
            if(!visited[nei]){
                if(isCycle(adj,nei,visited,inRecursion)) return true;
            }
            else if(inRecursion[nei]) return true;
        }
        inRecursion[i]=false;
        return false;
    }
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
        boolean visited[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && isCycle(adj,i,visited,inRecursion)) return false;
        }
        return true;
        
        // Queue<Integer> q = new LinkedList<>();
        // for(int i=0;i<n;i++){
        //     if(indegree[i]==0) q.add(i);
        // }
        // int c=0;
        // while(!q.isEmpty()){
        //     int u=q.remove();
        //     c++;
        //     for(int nei:adj.get(u)){
        //         indegree[nei]--;
        //         if(indegree[nei]==0) q.add(nei);
        //     }
        // }
        // if(c==n) return true;
        // else return false;
    }
}