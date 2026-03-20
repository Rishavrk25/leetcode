class Solution {
    public int[][] minAbsDiff(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        int res[][] = new int[n-k+1][m-k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int i_ = i+k-1;
                int j_ = j+k-1;
                if(i_<n && j_<m){
                    Set<Integer> set = new HashSet<>();
                    for(int s=i;s<=i_;s++){
                        for(int t=j;t<=j_;t++){
                            set.add(arr[s][t]);
                        }
                    }
                    List<Integer> list = new ArrayList<>(set);
                    Collections.sort(list);
                    int min = Integer.MAX_VALUE;
                    for(int s=1;s<list.size();s++){
                        int diff = Math.abs(list.get(s) - list.get(s-1));
                        min = Math.min(min,diff);
                    }
                    if(min==Integer.MAX_VALUE) min=0;
                    res[i][j]=min;
                }
            }
        }
        return res;
    }
}