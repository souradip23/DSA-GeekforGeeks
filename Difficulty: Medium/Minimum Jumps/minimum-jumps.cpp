class Solution {
  public:
    int minJumps(vector<int>& nums) {
        // code here
    int n = nums.size();

        for(int i = 1; i < n; i++){
            nums[i] = max(nums[i] + i, nums[i-1]);
        }

        int ans = 0;
        int idx = 0;

        while(idx < n - 1){
            if(nums[idx] == idx) return -1; // cannot move forward
            ans++;
            idx = nums[idx];
        }

        return ans;
    }

    
};