class Solution {
    public long[] distance(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> mapfreq = new HashMap<>(); // (ele, freq of ele in LHS)
        HashMap<Integer,Long> mapsum = new HashMap<>(); // (ele, sum of idx of ele in LHS)
        long ans[] = new long[n];
        for(int i=0;i<n;i++){
            if(!mapfreq.containsKey(arr[i])){
                mapfreq.put(arr[i],1);
                mapsum.put(arr[i],(long)i);
            }
            else{
                long a = mapfreq.get(arr[i]);
                long b = mapsum.get(arr[i]);
                ans[i] += (long)a*i - b;

                mapfreq.put(arr[i],mapfreq.get(arr[i])+1);
                mapsum.put(arr[i],mapsum.get(arr[i]) + i);

            }
            
        }
        mapfreq.clear();
        mapsum.clear();
        for(int i=n-1;i>=0;i--){
            if(!mapfreq.containsKey(arr[i])){
                mapfreq.put(arr[i],1);
                mapsum.put(arr[i],(long)i);
            }
            else{
                long a = mapfreq.get(arr[i]);
                long b = mapsum.get(arr[i]);
                ans[i] += b - (long)a*i;
                
                mapfreq.put(arr[i],mapfreq.get(arr[i])+1);
                mapsum.put(arr[i],mapsum.get(arr[i]) + i);
            }
            
        }
        return ans;
    }
}