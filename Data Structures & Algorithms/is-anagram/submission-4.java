class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> tableS=new HashMap<>();
        HashMap<Character,Integer> tableT=new HashMap<>();
        for(char c:s.toCharArray()){
            tableS.put(c,tableS.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            tableT.put(c,tableT.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> map:tableS.entrySet()){
            char key=map.getKey();
            int val=map.getValue();
            if(!(tableT.containsKey(key) && tableT.get(key).equals(val))){
                return false;
            }
            tableT.remove(key);
        }
        System.out.println(tableT.toString());
        return tableT.isEmpty()?true:false;
        
    }
}
