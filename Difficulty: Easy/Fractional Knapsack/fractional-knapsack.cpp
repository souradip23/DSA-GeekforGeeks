class Solution {
  public:
    double fractionalKnapsack(vector<int>& val, vector<int>& weight, int capacity) {
        // code here
        int n=val.size();
         vector<pair<double,int>>v;
    for(int i=0;i<n;i++){
        v.push_back({(double)val[i]/weight[i],i});
    }
    sort(v.begin(),v.end(),greater<pair<double,int>>());
    double totalvalue=0.0;
    for(int i=0;i<n;i++){
        int idx=v[i].second;
        if(capacity >= weight[idx]){
            totalvalue+=val[idx];
            capacity-=weight[idx];
        }else{
            totalvalue+=((double)val[idx]/weight[idx])*capacity;
            break;
        }
    }
    return totalvalue;
    }
};
