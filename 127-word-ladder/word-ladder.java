class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int steps = 1;
        
        while(!q.isEmpty()){
            
            int size=q.size();
            
            for(int i=0;i<size;i++){
                String curr=q.poll();
                
                char[] arr=curr.toCharArray();
                
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        
                        String temp=new String(arr);
                        
                        if(temp.equals(endWord)){
                            return steps+1;
                        }
                        if(wordSet.contains(temp)){
                            q.offer(temp);
                            wordSet.remove(temp);
                        }
                    }
                    arr[j]=original;
                }
                
            }
            
            steps++;
        }
        return 0;
    }
}
