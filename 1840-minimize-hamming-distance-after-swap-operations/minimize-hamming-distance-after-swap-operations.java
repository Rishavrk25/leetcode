class Solution {
    void dfs(List<List<Integer>> adj,int i,boolean visited[],List<Integer> list){
        visited[i] = true;
        list.add(i);
        for(int nei : adj.get(i)){
            if(!visited[nei]) dfs(adj,nei,visited,list);
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        List<List<Integer>> adj = new ArrayList<>();
        int n=source.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int p[] : allowedSwaps){
            int u=p[0];
            int v=p[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = 0; 
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            if(!visited[i]) dfs(adj,i,visited,list);
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int idx : list){
                if(!map.containsKey(source[idx])) map.put(source[idx],1);
                else map.put(source[idx],map.get(source[idx])+1);
            }
            for(int idx : list){
                if(map.containsKey(target[idx])){
                    map.put(target[idx],map.get(target[idx])-1);
                    if(map.get(target[idx])==0) map.remove(target[idx]);
                }
                else ans++;
            }
        }
        return ans;
        

    }
}