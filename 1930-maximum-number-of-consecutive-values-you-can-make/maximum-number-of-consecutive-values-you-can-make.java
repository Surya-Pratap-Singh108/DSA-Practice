class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int x=0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > x + 1) {
                break;
            }
            x += coins[i];
        }
        return x + 1;
    }
}