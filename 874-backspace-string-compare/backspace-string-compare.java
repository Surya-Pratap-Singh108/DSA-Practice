class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = buildStack(s);
        Stack<Character> st2 = buildStack(t);

        if (st1.size() != st2.size()) {
            return false;
        }

        while (!st1.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }

        return true;
    }

    public Stack<Character> buildStack(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            else {
                st.push(ch);
            }
        }

        return st;
    }
}