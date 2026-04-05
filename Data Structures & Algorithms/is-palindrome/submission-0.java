class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int l=0;
        int r=s.length()-1;
        while(l<r){
            // if(!(s.charAt(l)>='a' && s.charAt(l)<='z') || !(s.charAt(l)>='0' && s.charAt(l)<='9')){
            //     System.out.println(s.charAt(l)+"  was is it not char or digit?");
            //     l++;
            // }
            // else if(!(s.charAt(r)>='a' && s.charAt(r)<='z') || !(s.charAt(r)>='0' && s.charAt(r)<='9')){
            //     System.out.println(s.charAt(r)+"  was is it not char or digit?");
            //     r--;
            // }

            if(!Character.isLetterOrDigit(s.charAt(l))){
                // System.out.println(s.charAt(l)+"  was is it not char or digit?");
                l++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            else{
                 if(s.charAt(l)!=s.charAt(r)){
                System.out.println(s.charAt(l) +"-" +s.charAt(r) +"  was is it not char or digit?");
                return false;
            }
            l++;
            r--;
            }
        }
        return true;
    }
}
