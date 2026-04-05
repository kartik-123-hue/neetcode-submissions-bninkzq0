class Solution {

    public String encode(List<String> strs) {

        String encode="";
        for(String s:strs){
            encode+=String.valueOf(s.length())+"#"+s;
        }
        return encode;
    }

    public List<String> decode(String str) {


        /*
        ["Hello","World"]


        012345678910111213
        5#Hello5#W o r l d

        5 is found i=0
        # is found i=1

        j=i
        j+1 =2
        j+1+5=7


        */


        List<String> list=new ArrayList<>();
        for(int i=0;i<str.length();){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length=Integer.parseInt(str.substring(i,j));
            list.add(str.substring(j+1,j+1+length));
            i=j+1+length;
        }
        return list;
    }
}
