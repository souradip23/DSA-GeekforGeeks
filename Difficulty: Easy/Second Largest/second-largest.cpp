
// User function template for C++
class Solution {
  public:
    // Function returns the second
    // largest elements
    int getSecondLargest(vector<int> &arr) {
        // Code Here
        int largest=arr[0];
        int slargest=-1;
        for(int i=0;i<arr.size();i++){
            if(largest<arr[i]){
                slargest=largest;
                largest=arr[i];
            }else if(slargest<arr[i]&&largest>arr[i]){
                slargest=arr[i];
            }
        }
        return slargest;
    }
};