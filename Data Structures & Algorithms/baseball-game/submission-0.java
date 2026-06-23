class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String s:operations){
            switch(s){
                case "+":int score1=stack.pop();
                    int score2=stack.pop();
                    int sum=score1+score2;
                    stack.push(score2);
                    stack.push(score1);
                    stack.push(sum);
                    break;
                case "D":stack.push(2*stack.peek());
                break;
                case "C":stack.pop();break;
                default:stack.push(Integer.parseInt(s));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}