class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> table=new HashMap<>();
        // for(int i=0;i<strs.length;i++){
        //     table.put(new int[26],new ArrayList<>());
        // }
        for(String s:strs){
            int[] freq=new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            String uniqKey=Arrays.toString(freq);
            if(table.containsKey(uniqKey)){
                table.get(uniqKey).add(s);
            }
            else{
                List<String> newList=new ArrayList<>();
                newList.add(s);
                table.put(uniqKey,newList);
            }
        }

        List<List<String>> result=new ArrayList<>();
        for(String str:table.keySet()){
            result.add(table.get(str));
        }
        return result;
    }
}
