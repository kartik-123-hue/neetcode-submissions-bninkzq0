class Solution {
    public boolean makeEqual(String[] words) {
        int[] freq=new int[26];
        int flag=0;
        int n=words.length;
        for(String word:words){
            for(char c : word.toCharArray()){
                System.out.println("which char : "+c);
                int i=c-'a';
                if(freq[i]!=0){
                    freq[i]++;
                    System.out.println("what was the flag"+flag);
                    if(freq[i]%n==0){
                        System.out.println("did you change?");
                        flag++;
                    }
                }
                else{
                    freq[i]++;
                    if(freq[i]%n!=0){
                        flag--;
                    }
                }
                //this means we are modding to check if the char are arranged and used in others if yes it will have 0 as the remainder
                freq[i]%=n;
            }
        }
        return flag==0;
    }
}