class Solution {
    List<String> res=new ArrayList<>();
    HashMap<Character,String> dataMap;
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return res;
        }
        dataMap=new HashMap<>();
        dataMap.put('2',"abc");
        dataMap.put('3',"def");
        dataMap.put('4',"ghi");
        dataMap.put('5',"jkl");
        dataMap.put('6',"mno");
        dataMap.put('7',"pqrs");
        dataMap.put('8',"tuv");
        dataMap.put('9',"wxyz");
        String currStr="";
        backtrack(digits,0,currStr);
        return res;
    }
    public void backtrack(String digits,int i,String currStr){
        if(currStr.length()==digits.length()){
            res.add(currStr);
            return;
        }
        String chars=dataMap.get(digits.charAt(i));
        for(char c:chars.toCharArray()){
            backtrack(digits,i+1,currStr+c);
        }
    }
}
