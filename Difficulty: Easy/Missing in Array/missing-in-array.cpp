class Solution {
  public:
    int missingNum(vector<int>& arr) {
        // code here
        if(arr.size()==1&&arr[0]==1)return arr[0]+1;
        if(arr.size()==1&&arr[0]==2)return 1;
        int sum1=0;
        int sum2=0;
        int n=arr.size();
        for(int i=1;i<=n+1;i++){
            sum1+=i;
        }
        for(int i=0;i<arr.size();i++){
            sum2+=arr[i];
        }
        return sum1-sum2;
    }
};