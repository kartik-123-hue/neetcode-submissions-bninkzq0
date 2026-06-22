class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        backtrack(s,0,0,curr);
        return res;
    }

    public void backtrack(String s,int j,int i,List<String> curr){
        if(i>=s.length()){
            if(i==j){
                res.add(new ArrayList<>(curr));
                // curr=new ArrayList<>();
            }
            return;
        }
        if(isPalindrome(s,j,i)){
            // System.out.println("What is the current string "+s.substring(i,j+1));
            // System.out.println(" expansion index change : i "+(i+1)+"-"+(j+1));
            curr.add(s.substring(j,i+1));
            backtrack(s,i+1,i+1,curr);
            curr.remove(curr.size()-1);
        }
        //  System.out.println(" backtrack index change : i "+i+"-"+(j+1));
        backtrack(s,j,i+1,curr);
    }

    public boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
