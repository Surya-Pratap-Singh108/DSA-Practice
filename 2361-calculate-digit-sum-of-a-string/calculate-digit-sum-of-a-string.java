
class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            StringBuilder next = new StringBuilder();
            int len = s.length();

            for (int i = 0; i < len; i += k) {
                int sum = 0;
                int end = Math.min(i + k, len);

                for (int j = i; j < end; j++) {
                    sum += s.charAt(j) - '0';
                }

                next.append(sum);
            }

            s = next.toString();
        }

        return s;
    }
}
