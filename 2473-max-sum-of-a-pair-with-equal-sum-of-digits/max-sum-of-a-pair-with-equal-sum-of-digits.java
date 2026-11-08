
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;

        for (int num : nums) {
            int sum = digitSum(num);

            if (map.containsKey(sum)) {
                max = Math.max(max, num + map.get(sum));
            }

            // Store the largest number for this digit sum
            map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
        }

        return max;
    }

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
