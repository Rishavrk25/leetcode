class Solution {
    void dfs(Map<String,List<String>> adjMap,Set<String> visited,String u,List<String> sublist){
        visited.add(u);
        sublist.add(u);
        // if(!adjMap.containsKey(u)){
        //     return;
        // }
        for(String nei: adjMap.get(u)){
            if(!visited.contains(nei)){
                dfs(adjMap,visited,nei,sublist);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<String>> adjMap = new HashMap<>();
        for(List<String> list : accounts){
            String firstEmail=list.get(1);
            if(!adjMap.containsKey(firstEmail)) adjMap.put(firstEmail,new ArrayList<>());
            for(int i=2;i<list.size();i++){
                String email=list.get(i);
                adjMap.get(firstEmail).add(email);
                if(!adjMap.containsKey(email)) adjMap.put(email,new ArrayList<>());
                adjMap.get(email).add(firstEmail);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(List<String> list : accounts){
            String firstEmail=list.get(1);
            if(!visited.contains(firstEmail)){
                List<String> sublist = new ArrayList<>();
                dfs(adjMap,visited,firstEmail,sublist);
                Collections.sort(sublist);
                sublist.add(0,list.get(0));
                ans.add(sublist);
            }
      
        }
        return ans;
    }
}