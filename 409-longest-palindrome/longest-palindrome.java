// class Solution {
//     public int longestPalindrome(String s) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         for (int i=0;i<s.length() ;i++ ){
//             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//         }
//         int ans=0;
//         boolean hasOdd=false;
//         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//             char key=entry.getKey();
//             int value=entry.getValue();
//             if(value%2==0){
//                 ans+=value;
//             }
//             else{
//                 ans+=value-1;
//                 hasOdd=true;
//             }
            
//         }
//         if(hasOdd)ans++;       
//         return ans;
//     }
// }
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128]; // ASCII

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        boolean hasOdd = false;

        for (int val : count) {
            if (val % 2 == 0) {
                ans += val;
            } else {
                ans += val - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) ans++;

        return ans;
    }
}