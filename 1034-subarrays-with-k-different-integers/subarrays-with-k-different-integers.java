class Solution {
    int atmostk(int arr[],int k){
        Map<Integer,Integer> map = new HashMap<>();
        int n=arr.length;
        int i=0;
        int j=0;
        int c=0;
        while(j<n){
            if(!map.containsKey(arr[j])) map.put(arr[j],1);
            else map.put(arr[j],map.get(arr[j])+1);
            while(map.size()>k){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0) map.remove(arr[i]);
                i++;
            }
            c+=(j-i);
            j++;
        }
        return c;
    }
    public int subarraysWithKDistinct(int[] arr, int k) {
        return atmostk(arr,k)-atmostk(arr,k-1);
    }
}