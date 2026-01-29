class Solution {
    public String firstNonRepeating(String s) {
     
        int[] freq = new int[26];
       
        Queue<Character> q = new LinkedList<>(); 
        StringBuilder result = new StringBuilder(); 
        for (char ch : s.toCharArray()) { 
            
            freq[ch - 'a']++;
         
            q.add(ch); 
          
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) { 
                q.poll(); 
                
            }
        
            if (!q.isEmpty()) { 
                result.append(q.peek()); 
                
            } 
            else { 
                result.append('#'); 
                
            } 
            
        } 
        return result.toString();
    }
}