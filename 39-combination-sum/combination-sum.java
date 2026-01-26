class Solution {
    void helper(int arr[],int t,int idx,List<Integer> list,List<List<Integer>> ans){
        if(t<0) return;
        if(t==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            list.add(arr[i]); // DO
            helper(arr,t-arr[i],i,list,ans); // EXPLORE
            list.remove(list.size()-1); // UNDO
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,target,0,list,ans);
        return ans;
    }
}