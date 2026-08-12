class Solution {
  public:
    vector<int> findDuplicates(vector<int>& arr) {
        // code here
        vector<int>v;
        unordered_map<int,int>m;
        for(int num: arr){
            m[num]++;
        }
        for(auto &a : m){
            int ele=a.first;
            int freq=a.second;
            if(freq==2){
                v.push_back(ele);
            }
        }
        sort(v.begin(),v.end());
        return v;
    }
};