class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stringStack.push(current);

                current = new StringBuilder();
            }
            else if(ch == ')'){
                
                StringBuilder previous = stringStack.pop();
            
                previous.append(current.reverse());
                
                current=previous;
            }
            else{
                current.append(ch);
            }
        }
        
        return current.toString();
    }
}