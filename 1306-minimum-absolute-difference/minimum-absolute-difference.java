class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            minDiff = Math.min(minDiff,arr[i+1]-arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff = arr[i+1]-arr[i];
            if(diff==minDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }
        return ans;
    }
}