class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        StringBuilder validP=new StringBuilder();
        backtrack(n,0,0,validP);
        return res;
    }
    public void backtrack(int n,int open ,int close,StringBuilder valid){
        if(open==n && close==n){
            res.add(valid.toString());
            return;
        }
        if(open<n){
            valid.append("(");
            backtrack(n,open+1,close,valid);
            valid.deleteCharAt(valid.length()-1);
        }   

        if(close<open){
            valid.append(")");
            backtrack(n,open,close+1,valid);
            valid.deleteCharAt(valid.length()-1);
        }
    }
}
