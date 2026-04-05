class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> freq=new HashMap<>();
        int len=0;
        int l=0;int maxf=0;
        for(int r=0;r<s.length();r++){
            freq.put(s.charAt(r),freq.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,freq.get(s.charAt(r)));
            while((r-l+1)-maxf>k){
                freq.put(s.charAt(l),freq.get(s.charAt(l))-1);
                l++;
            }
            len=Math.max(len,r-l+1);
        }
        return len;
    }
}
