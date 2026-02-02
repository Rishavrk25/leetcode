class Solution {
    boolean isCycle(List<List<Integer>> adj,int i,List<Integer> list,boolean visited[],boolean inRecursion[]){
        visited[i]=true;
        inRecursion[i]=true;
        for(int nei:adj.get(i)){
            if(!visited[nei]){
                if(isCycle(adj,nei,list,visited,inRecursion)) return true;
            }
            else if(inRecursion[nei]) return true; 
        }
        list.add(0,i);
        inRecursion[i]=false;
        return false;
    }
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int arr[]:prerequisites){
            int u=arr[0];
            int v=arr[1];
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        List<Integer> list = new ArrayList<>();
        boolean flag = false; // no cycle
        for(int i=0;i<n;i++){
            if(!visited[i] && isCycle(adj,i,list,visited,inRecursion)){
                flag = true; // cycle
                break;
            }
        }
        if(flag) return new int[]{};
        int ans[] = new int[n];
        for(int i=0;i<n;i++) ans[i]=list.get(i);
        return ans;

    }
}