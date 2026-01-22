class Solution {
    public StringBuilder document; 
    public Stack<Character> redoStack;
    
    public Solution() { 
        document = new StringBuilder(); 
        redoStack = new Stack<>(); 
        
    }
    
    public void append(char x) { 
       document.append(x); 
       redoStack.clear(); 
    }

    public void undo() { 
        if (document.length() > 0) { 
            char last = document.charAt(document.length() - 1); 
            document.deleteCharAt(document.length() - 1); 
            redoStack.push(last); 
            
        } 
        
    }

   public void redo() { 
       if (!redoStack.isEmpty()) { 
           char ch = redoStack.pop(); 
           document.append(ch); 
           
       } 
       
   }

    public String read() { 
        return document.toString(); 
        
    }
}
