class Solution {
    int parent[];
    int size[];
    int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b]=a;
                size[a]+=size[b];
            }
            else{
                parent[a]=b;
                size[b]+=size[a];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> list = accounts.get(i);
            for(int j=1;j<list.size();j++){
                String email=list.get(j);
                if(!map.containsKey(email)) map.put(email,i);
                else union(i,map.get(email));
            }
        }
        List<List<String>> merged = new ArrayList<>();
        for(int i=0;i<accounts.size();i++) merged.add(new ArrayList<>());
        for(String key:map.keySet()){
            int val = find(map.get(key));
            merged.get(val).add(key);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            List<String> list = merged.get(i);
            if(list.size()==0) continue;
            Collections.sort(list);
            list.add(0,accounts.get(i).get(0));
            ans.add(list);
        }
        return ans;
    }
}