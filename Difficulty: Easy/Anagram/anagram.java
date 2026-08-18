class Solution {
    public static  String clean(String s){
       StringBuilder sb = new StringBuilder();

       for (char ch : s.toLowerCase().toCharArray()) {

           if (Character.isLetterOrDigit(ch)) {
               sb.append(ch);
           }
       }

       return sb.toString();
    }
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        String str1=clean(s1);
        String str2=clean(s2);
        
        if(str1.length() != s2.length()) return false;
        
        int [] freq=new int[256];
        
        for(char ch : str1.toCharArray()){
            freq[ch]++;
        }
        
        for( char ch : str2.toCharArray()){
            freq[ch]--;
            if(freq[ch]< 0){
                return false;
            }
        }
        return true;
    }
}