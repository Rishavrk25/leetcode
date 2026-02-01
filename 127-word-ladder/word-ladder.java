class Solution {
    List<String> getNeighbours(Set<String> set, String s){
        int n=s.length();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(char ch='a';ch<='z';ch++){
                if(ch==s.charAt(i)) continue;
                String sub = s.substring(0,i) + ch + s.substring(i+1,n);
                if(set.contains(sub)){
                    list.add(sub);
                }
            }
        }
        return list;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // copy wordList to set
        Set<String> set = new HashSet<>(wordList);
        // Bfs
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String s = q.remove();
                if(s.equals(endWord)){
                    return level+1;
                }
                List<String> list = getNeighbours(set,s);
                for(String nei : list){
                    q.add(nei);
                    set.remove(nei);
                }
            }
            level++;
        }
        return 0;
    }
}