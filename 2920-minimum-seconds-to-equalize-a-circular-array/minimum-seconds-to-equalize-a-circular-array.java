class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n=nums.size();
        int ans = n;
        for(int i=0;i<n;i++){
            nums.add(nums.get(i));
        }
        HashMap<Integer,Integer> map = new HashMap<>(); // ele, last idx
        HashMap<Integer,Integer> maxTime = new HashMap<>(); // ele, time
        n=nums.size();
        for(int i=0;i<n;i++){
            int ele = nums.get(i);
            if(!map.containsKey(ele)) map.put(ele,i);
            else{
                int t = (i-map.get(ele))/2;
                if(!maxTime.containsKey(ele)) maxTime.put(ele,t);
                else maxTime.put(ele,Math.max(maxTime.get(ele),t));
                map.put(ele,i);
            }
        }
        for(int ele:maxTime.keySet()){
            int time = maxTime.get(ele);
            ans = Math.min(ans,time);
        }
        return ans;
    }
}