class Solution {

    private boolean diagonalChecking(char[][] mat , String word , int i_ , int j_){
        int cnt = 0;
        int k = 0;

        for(int j = j_ , i = i_  ; i >= 0 && j >= 0 && k != word.length(); i-- , j--){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        k = 0;
        for(int j = j_ , i = i_  ; i >= 0 && j < mat[0].length && k != word.length(); i-- , j++){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        k = 0;
        for(int j = j_ , i = i_  ; i < mat.length && j < mat[0].length && k != word.length() ; i++ , j++){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        k = 0;
        for(int j = j_ , i = i_  ; i < mat.length && j >= 0 && k != word.length() ; i++ , j--){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        return false;
    }

    private boolean verticalChecking(char[][] mat , String word , int i_ , int j){
        int cnt = 0;
        int k = 0;

        for(int i = i_ ; i < mat.length && k != word.length(); i++){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        k = 0;
        for(int i = i_ ; i >= 0 && k != word.length() ; i--){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        return false;
    }

    private boolean horizontalChecking(char[][] mat , String word , int i , int j_){
        int cnt = 0;
        int k = 0;

        for(int j = j_ ; j < mat[0].length && k != word.length() ; j++){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        k = 0;
        for(int j = j_ ; j >= 0 && k != word.length(); j--){
            if(mat[i][j] != word.charAt(k)) break;
            else k++;
        }
        if(k == word.length()) return true;

        return false;
    }
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        // code here

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                //check for 2 horizontal
                if(horizontalChecking(mat , word , i , j)){
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(i,j));
                    result.add(temp);
                }
                //check for 2 vertical
                else if(verticalChecking(mat , word , i , j)){
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(i,j));
                    result.add(temp);
                }
                //check for 4 diagonal
                else if(diagonalChecking(mat , word , i , j)){
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(i,j));
                    result.add(temp);
                }
            }
        }
        return result;
    }
}