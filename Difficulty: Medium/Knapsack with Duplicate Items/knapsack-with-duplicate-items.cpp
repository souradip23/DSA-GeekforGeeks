class Solution {
  public:
    int knapSack(vector<int>& val, vector<int>& wt, int W) {
        // code here
    
    vector<int> dp(W + 1, 0);

    for (int i = 0; i < wt.size(); i++) {

        for (int w = wt[i]; w <= W; w++) {

            dp[w] = max(
                dp[w],
                val[i] + dp[w - wt[i]]
            );
        }
    }

    return dp[W];
    }
};