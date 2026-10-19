class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                open++;
            } else {
                open--;
            }

            if (open < 0) {
                ans++;
                open+=2;
            }
        }

        return ans ;
    }
}