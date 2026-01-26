class Solution {
    void helper(int arr[],int t,int idx,List<Integer> list,List<List<Integer>> ans){
        if(t<0) return;
        if(t==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            helper(arr,t-arr[i],i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,target,0,list,ans);
        return ans;
    }
}