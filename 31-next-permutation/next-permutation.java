class Solution {
    void reverse(int arr[],int i,int j){
        while(i<j){
            int t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        // System.out.println(idx);
        if(idx==-1){
            reverse(arr,0,n-1);
            return;
        }
        else reverse(arr,idx+1,n-1);
        int lg=0;
        for(int i=idx+1;i<n;i++){
            if(arr[i]>arr[idx]){
                lg = i;
                break;
            }
        }
        int t = arr[idx];
        arr[idx]=arr[lg];
        arr[lg]=t;

    }
}