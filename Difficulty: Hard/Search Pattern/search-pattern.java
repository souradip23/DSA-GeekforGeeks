class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
             for(int i=0;i<=txt.length()-pat.length();i++)
             {
                 String s =txt.substring(i , i+pat.length() ); 
                 if( s.equals(pat) ) ans.add(i);
             } 
           return ans;
    }
}