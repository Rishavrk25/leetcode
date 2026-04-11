class Solution {
    public int minimumDistance(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
            else map.get(arr[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int key:map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size()<3) continue;
            // if(list.size()==3){
            //     int min = list.get(0);
            //     int max = list.get(list.size()-1);
            //     int d = 2 * (max - min);
            //     ans = Math.min(ans,d);
            // }
            // else{
                int i=0;
                int j=2;
                while(j<list.size()){
                    int min = list.get(i);
                    int max = list.get(j);
                    int d = 2 * (max - min);
                    ans = Math.min(ans,d);
                    i++;
                    j++;
                }
            // }
            
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}