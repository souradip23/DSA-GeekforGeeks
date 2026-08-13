class Solution {
    public void sort012(int[] arr) {
        // code here
       int c0=0;
       int c1=0;
       int c2=0;
       for(int i=0;i<arr.length;i++){
           if(arr[i]==0){
               c0++;
           }else if(arr[i]==1){
               c1++;
           }else{
               c2++;
           }
       }
       int idx=0;
       for(int i=0;i<c0;i++){
           arr[idx++]=0;
       }
        for(int i=0;i<c1;i++){
           arr[idx++]=1;
       }
        for(int i=0;i<c2;i++){
           arr[idx++]=2;
       }
    }
}