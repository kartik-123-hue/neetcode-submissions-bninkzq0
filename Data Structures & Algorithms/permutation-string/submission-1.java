class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] frqS1=new int[26];
        int[] frqS2=new int[26];

        for(int i=0;i<s1.length();i++){
            frqS1[s1.charAt(i)-'a']++;
            frqS2[s2.charAt(i)-'a']++;
        }

        for(int i=s1.length();i<s2.length();i++){
            if(Arrays.equals(frqS1,frqS2)){
                return true;
            }
            frqS2[s2.charAt(i-s1.length())-'a']--;
            frqS2[s2.charAt(i)-'a']++;
        }

        return Arrays.equals(frqS1,frqS2);
    }
}
