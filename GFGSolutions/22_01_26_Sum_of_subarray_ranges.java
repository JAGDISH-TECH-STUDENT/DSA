class Solution {
    public int subarrayRanges(int[] arr) {
        // code here
        long maxSum = sumSubarrayMax(arr); 
        long minSum = sumSubarrayMin(arr); 
        return (int)(maxSum - minSum);
        
    }
    private long sumSubarrayMax(int[] arr) { 
        int n = arr.length; 
        long res = 0; 
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>(); 
        for (int i = 0; i <= n; i++) { 
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] < (i < n ? arr[i] : Integer.MAX_VALUE))) { 
                int idx = stack.pop(); 
                int left = stack.isEmpty() ? idx + 1 : idx - stack.peek(); 
                int right = i - idx; 
                res += (long) arr[idx] * left * right; 
                
            } 
            stack.push(i); 
            
        } 
        return res; 
        
    }
    private long sumSubarrayMin(int[] arr) { 
        int n = arr.length; 
        long res = 0; 
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>(); 
        for (int i = 0; i <= n; i++) { 
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > (i < n ? arr[i] : Integer.MIN_VALUE))) { 
                int idx = stack.pop(); 
                int left = stack.isEmpty() ? idx + 1 : idx - stack.peek(); 
                int right = i - idx; 
                res += (long) arr[idx] * left * right; 
                
            } 
            stack.push(i); 
            
        } 
        return res; 
        
    }
    
}
