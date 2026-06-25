class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> table=new HashMap<>();
        for(String s:arr){
            table.put(s,table.getOrDefault(s,0)+1);
        }
        for(String s:arr){
            if(table.get(s)==1){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}