class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        List<Integer> ng = new ArrayList<>();
        int max = 0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            ng.add(0,max);
        }
        List<Integer> pg = new ArrayList<>();
        max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
            pg.add(max);
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            int a=ng.get(i);
            int b=pg.get(i);
            ans += Math.min(a,b) - arr[i];
        }
        return ans;
    }
}