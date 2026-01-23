class Solution {
    void helper(int arr[],int i,List<List<Integer>> ans,List<Integer> list){
        if(i==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        helper(arr,i+1,ans,list);
        list.add(arr[i]);
        helper(arr,i+1,ans,list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsets(int[] arr) {
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(arr,0,ans,list);
        return ans;
    }
}