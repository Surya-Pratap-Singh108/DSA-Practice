
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        int even = 1;
        int odd = 0;

        int prefix = 0;
        long ans = 0;

        for (int num : arr) {

            prefix += num;

            if (prefix % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }

            ans %= MOD;
        }

        return (int) ans;
    }
}
