class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> sortList=new HashMap<>();
        for(String s:strs){
            char[] array=s.toCharArray();Arrays.sort(array);
            String sortedString=new String(array);
            if(sortList.containsKey(sortedString)){
                sortList.get(sortedString).add(s);
            }
            else{
               List<String> list=new ArrayList<>();
               list.add(s);
               sortList.put(sortedString,list);
            }
        }

        List<List<String>> result=new ArrayList<>();
        for(String k:sortList.keySet()){
            result.add(sortList.get(k));
        }
        return result;
    }
}
