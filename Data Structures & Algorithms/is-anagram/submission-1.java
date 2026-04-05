class Solution {
    public boolean isAnagram(String s, String t) {
      int[] sArr=new int[26];
      int[] tArr=new int[26];
      for(char c :s.toCharArray()){
        sArr[c-'a']++;
      }

      for(char c:t.toCharArray()){
        tArr[c-'a']++;
      } 

      return Arrays.equals(sArr,tArr);
    }
}
