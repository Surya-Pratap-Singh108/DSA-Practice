class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
          this.ch=ch;   
          this.freq=freq;   
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                return b.freq-a.freq;//max Heap
            }
            );
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            pq.add(new Pair(key,value));
        }
        StringBuilder ans = new StringBuilder();
        Pair prev=null;
        while (!pq.isEmpty()){
            Pair curr=pq.poll();
            ans.append(curr.ch);
            curr.freq--;
            if(prev!=null&&prev.freq>0){
                pq.add(prev);
            }
            prev=curr;
        }
         if (ans.length() != s.length()) return "";
         return ans.toString();
    }
}