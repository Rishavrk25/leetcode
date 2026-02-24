class Solution {
    public int totalFruit(int[] arr) {
        int n=arr.length;
        int i=0;
        int j=0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>(); // ele,freq
        while(j<n){
            if(!map.containsKey(arr[j])) map.put(arr[j],1);
            else map.put(arr[j],map.get(arr[j])+1);
            while(map.size()>2){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0) map.remove(arr[i]);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}