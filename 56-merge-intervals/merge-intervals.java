class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int n=arr.length;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{arr[0][0],arr[0][1]});
        for(int i=1;i<n;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            int lastArr[] = list.get(list.size()-1);
            if(lastArr[1] >= a){
                lastArr[1] = Math.max(lastArr[1],b);
            }
            else list.add(new int[]{a,b});
        }
        int ans[][] = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }
}