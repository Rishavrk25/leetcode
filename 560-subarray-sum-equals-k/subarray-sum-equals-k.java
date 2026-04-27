class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map = new HashMap<>(); // sum,freq
        int sum=0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!map.containsKey(sum)) map.put(sum,1);
            else map.put(sum,map.get(sum)+1);
            sum+=arr[i];
            if(map.containsKey(sum-k)) ans+=map.get(sum-k);
        }
        return ans;
    }
}