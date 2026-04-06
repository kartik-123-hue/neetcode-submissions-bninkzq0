class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            int operand1=0;
            int operand2=0;

            switch(s){
                case "+":
                operand1=stack.pop();
                operand2=stack.pop();
                stack.push(operand2+operand1);break;
                case "-":
                operand1=stack.pop();
                operand2=stack.pop();
                stack.push(operand2-operand1);break;
                case "*":
                operand1=stack.pop();
                operand2=stack.pop();
                stack.push(operand2*operand1);break;
                case "/":
                operand1=stack.pop();
                operand2=stack.pop();
                if(operand1!=0){
                    stack.push(operand2/operand1);
                }
                else{
                    stack.push(0);
                }
                break;
                default : stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
