


class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean isBalanced(String x)
    {
        // add your code 
        int len=Integer.MAX_VALUE;
        while(len>x.length()){
            len=x.length();
            x=x.replace("()","");
            x=x.replace("{}","");
            x=x.replace("[]","");
        }
        return x.length()>0?false:true;
    }
}