class Solution {
    public int compress(char[] arr) {
        int n=arr.length;
        int i=0;
        int j=0;
        String str="";
        while(j<n){
            if(arr[i]==arr[j]){
                j++;
            }
            else{
                str=str+arr[i];
                int len=j-i;
                if(len>1) str=str+len;
                i=j;
            }
        }
        str=str+arr[i];
        int len=j-i;
        if(len>1) str=str+len;
        for(int k=0;k<str.length();k++){
            arr[k]=str.charAt(k);
        }
        return str.length();
    }
}