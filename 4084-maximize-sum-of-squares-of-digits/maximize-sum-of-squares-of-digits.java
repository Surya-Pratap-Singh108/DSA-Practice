class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 1 || sum > 9 * num) return "";

        int nines = sum / 9;
        int rem = sum % 9;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nines; i++) {
            ans.append('9');
        }

        if (rem > 0) {
            ans.append(rem);
        }

        while (ans.length() < num) {
            ans.append('0');
        }

        return ans.toString();
    }
}