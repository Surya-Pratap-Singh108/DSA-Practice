class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> names = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String str:deadends){
            names.add(str);
        }
        if(names.contains("0000")) return -1;
        int ans=0;
        
        Queue<String> q=new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
               String curr=q.poll();
               if(curr.equals(target))return ans;
               for(int j=0;j<curr.length();j++){
                   StringBuilder sb1 = new StringBuilder(curr);
                    char next1 = curr.charAt(j) == '9' ? '0' : (char)(curr.charAt(j) + 1);
                    sb1.setCharAt(j, next1); 

                    String result1 = sb1.toString();
                    if(!names.contains(result1)&&!visited.contains(result1)){
                        visited.add(result1);
                        q.offer(result1);
                    }
                   StringBuilder sb2 = new StringBuilder(curr);
                    char next2 = curr.charAt(j) == '0' ? '9' : (char)(curr.charAt(j) - 1);
                    sb2.setCharAt(j, next2); 

                    String result2 = sb2.toString();
                    if(!names.contains(result2)&&!visited.contains(result2)){
                        visited.add(result2);
                        q.offer(result2);
                    }
               }
            }
            
            ans++;
        }
        
        
        return -1;
    }
}