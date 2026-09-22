class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency of s1
        for (char ch : s1.toCharArray()) {
            count1[ch - 'a']++;
        }

        // First window
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) return true;

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            char left = s2.charAt(i - s1.length());
            char right = s2.charAt(i);

            count2[left - 'a']--;
            count2[right - 'a']++;

            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }
}