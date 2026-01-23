class Solution {
    void helper(List<Integer> arr,List<Integer> list,List<List<Integer>> ans){
        int n=arr.size();
        if(n==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            List<Integer> newArr = new ArrayList<>(arr);
            list.add(arr.get(i));
            newArr.remove(i);
            helper(newArr,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for(int ele:nums) arr.add(ele);
        helper(arr,list,ans);
        return ans;
    }
}