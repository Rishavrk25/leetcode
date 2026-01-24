class Solution {
    void helper(int arr[],int t,int i,int sum,List<Integer> list,List<List<Integer>> ans){
        if(i==arr.length){
            if(sum==t) ans.add(new ArrayList<>(list));
            return;
        }
        // take
        list.add(arr[i]);
        if(sum+arr[i]<=t) helper(arr,t,i,sum+arr[i],list,ans);
        list.remove(list.size()-1);
        //skip
        helper(arr,t,i+1,sum,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,target,0,0,list,ans);
        return ans;
    }
}