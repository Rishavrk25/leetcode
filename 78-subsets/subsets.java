class Solution {
    void helper(int arr[],int idx,List<Integer> list ,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
            list.add(arr[i]);
            helper(arr,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,0,list,ans);
        return ans;
    }
}