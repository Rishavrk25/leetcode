class Solution {
    int countSetBits(int n){
        int c=0;
        while(n>0){
            if((n&1)==1) c++;
            n=n>>1;
        }
        return c;
    }
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<n;i++){
            int c=countSetBits(arr[i]);
            pq.add(new int[]{arr[i],c});
        }
        int k=0;
        while(!pq.isEmpty()){
            arr[k++]=pq.remove()[0];
        }
        return arr;
    }
}