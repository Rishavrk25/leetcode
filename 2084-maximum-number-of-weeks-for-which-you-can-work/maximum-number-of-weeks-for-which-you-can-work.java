class Solution {
    public long numberOfWeeks(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        long sum = 0;
        for(int ele:arr) sum+=ele;
        long rem = sum-arr[n-1];
        if(rem <= arr[n-1]-1) return (long)2*rem + 1;
        else return sum;
    }
}