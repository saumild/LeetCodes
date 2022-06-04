class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operands = "+-*/";
        for(String s: tokens){
            
            int ans = -1;
            if(operands.contains(s)){
                if(stack.size()>=2){
                    int a = stack.pop();
                    int b = stack.pop();
                    
                    switch(s){
                        case "+": ans = a + b;break;
                        case "-": ans = b - a;break;
                        case "*": ans = a*b;break;
                        case "/": ans = b/a;break;
                    }
                    
                    stack.push(ans);    
                    
                }
            }else{
                stack.push(Integer.valueOf(s));
            }
            
        }
        
        return stack.pop();
    }
}