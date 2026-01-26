class Solution {
    void helper(int arr[],int idx,int k,int t,List<Integer> list ,List<List<Integer>> ans){
        if(t<0) return;
        if(k==0){
            if(t==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=idx;i<9;i++){
            list.add(arr[i]);
            helper(arr,i+1,k-1,t-arr[i],list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        helper(arr,0,k,n,list,ans);
        return ans;

    }
}