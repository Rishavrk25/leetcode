class Solution {
    void helper(int arr[],int i,List<Integer> list,Set<List<Integer>> set){
        if(i==arr.length){
            set.add(new ArrayList<>(list));
            return;
        }
        // take
        list.add(arr[i]);
        helper(arr,i+1,list,set);
        list.remove(list.size()-1); // backtrack
        // skip
        helper(arr,i+1,list,set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums,0,list,set);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}