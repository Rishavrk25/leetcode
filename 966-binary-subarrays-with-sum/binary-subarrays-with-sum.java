class Solution {
    public int numSubarraysWithSum(int[] arr, int k) {
        int n=arr.length;
        Map<Integer,Integer> map = new HashMap<>(); // sum,freq
        map.put(0,1);
        int sum=0;
        int c=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)) c+=map.get(sum-k);
            if(!map.containsKey(sum)) map.put(sum,1);
            else map.put(sum,map.get(sum)+1);
        }
        return c;
    }
}