class Solution {
    void helper(int arr[],int t,int i,int sum,List<Integer> list,Set<List<Integer>> set){
        if(i==arr.length){
            List<Integer> newlist= new ArrayList<>(list);
            if(sum==t && !set.contains(newlist)) set.add(newlist);
            return;
        }
        // take
        list.add(arr[i]);
        if(sum+arr[i]<=t) helper(arr,t,i+1,sum+arr[i],list,set);
        list.remove(list.size()-1);
        // skip all duplicates of current element
        int j = i;
        while (j < arr.length && arr[j] == arr[i]) j++;
        // skip
        helper(arr,t,j,sum,list,set);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,target,0,0,list,set);
        List<List<Integer>> ans =new ArrayList<>(set);
        return ans;
    }
}