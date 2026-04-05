class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqOfS=new int[26];
        int[] freqOfT=new int[26];

        for(char ch:s.toCharArray()){
            freqOfS[ch-'a']++;
        }

         for(char ch:t.toCharArray()){
            freqOfT[ch-'a']++;
        }

        return Arrays.equals(freqOfS,freqOfT);
    }
}
