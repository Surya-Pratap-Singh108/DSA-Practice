class Solution { 
    public boolean isAnagram(String s, String t) {
         if(s.length()!=t.length()){
             return false; 
         }
          HashMap<Character,Integer> m=new HashMap<>(); 
          for (int i = 0; i < s.length(); i++) { 
            if(m.containsKey(s.charAt(i))){ 
                m.put(s.charAt(i),m.get(s.charAt(i))+1); 
                } else{
                     m.put(s.charAt(i),1); 
                }
            }
           for (int i = 0; i < t.length(); i++) {
             if(m.containsKey(t.charAt(i))){
                 m.put(t.charAt(i),m.get(t.charAt(i))-1);
                  if(m.get(t.charAt(i))==0) {
                     m.remove(t.charAt(i));
                    } 
                 } 
                else{
                 return false; 
                 } 
            }
        return m.isEmpty(); 
    } 
}