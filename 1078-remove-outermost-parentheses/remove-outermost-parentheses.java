class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;

        int currStartIndex = 0;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            ans.append(s.charAt(i));

            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {

                // remove outer ')'
                ans.deleteCharAt(ans.length() - 1);

                // remove outer '('
                ans.deleteCharAt(currStartIndex);

                // next primitive starts here
                currStartIndex = ans.length();

                open = 0;
                close = 0;
            }
        }

        return ans.toString();
    }
}