class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        // Step 1: Find the dominant element using Boyer-Moore
        int dominant = 0;
        int balance = 0;

        for (int num : nums) {
            if (balance == 0) {
                dominant = num;
            }

            if (num == dominant) {
                balance++;
            } else {
                balance--;
            }
        }

        // Step 2: Count total occurrences of the dominant element
        int totalCount = 0;

        for (int num : nums) {
            if (num == dominant) {
                totalCount++;
            }
        }

        // Step 3: Check every possible split
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                count++;
            }

            if (count * 2 > i + 1 &&
                (totalCount - count) * 2 > n - i - 1) {
                return i;
            }
        }

        return -1;
    }
}