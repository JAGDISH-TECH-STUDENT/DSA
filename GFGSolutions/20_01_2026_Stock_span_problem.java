class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
       ArrayList<Integer> span = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) { 
            while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) { 
                stack.pop(); 
                
            }
            if (stack.isEmpty()) { 
                span.add(i + 1);
            } 
            else { 
                span.add(i - stack.peek()[1]);
                
            }
            stack.push(new int[]{arr[i], i}); 
            
        }
        return span;
        
    }
}