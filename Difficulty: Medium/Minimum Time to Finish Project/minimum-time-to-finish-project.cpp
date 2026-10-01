class Solution {
  public:
    int minTime(vector<int> &duration, vector<vector<int>> &dependencies) {
        // code here
        int n = duration.size();
        vector<int> finishTime = duration; // ith module ko khatam hona ma kita time laga
        
        // we can apply khans algorithm (Topological Sort)
        
        vector<int> indegree(n, 0);
        unordered_map<int, vector<int>> adj;
        
        for (auto & dep : dependencies) {
            
            int u = dep[0];
            int v = dep[1];
            
            adj[u].push_back(v);
            indegree[v]++;
        }
        
        queue<int> q;
        int count = 0; // if we would vist all n nodes then we would complete project
        
        for (int i = 0; i < n; i++) {
            
            if (indegree[i] == 0) {
                q.push(i);
                count++;
            }
        }
        
        while (!q.empty()) {
            
            int u = q.front();
            q.pop();
            
            for (int& v : adj[u]) {
                
                finishTime[v] = max(finishTime[v], finishTime[u] + duration[v]);
                indegree[v]--;
                
                if (indegree[v] == 0) {
                    q.push(v);
                    count++;
                }
            }
        }
        
        if (count < n) return -1; // we could not vist all nodes means cycle present
        
        int ans = *max_element(begin(finishTime), end(finishTime));
        
        return ans;
    }
};