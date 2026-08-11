class Solution {
  public:
    int maxWater(vector<int> &arr) {
        // code here
         int lmx=0,rmx=0,l=0,r=arr.size()-1,res=0;
        while(l<=r){
            if(arr[l]<=arr[r]){
                if(arr[l]>lmx) lmx=arr[l];
                else res+=lmx-arr[l];
                l++;
            }
            else{
                if(arr[r]>rmx) rmx=arr[r];
                else res+=rmx-arr[r];
                r--;
            }
        }
        return res;
    }
};