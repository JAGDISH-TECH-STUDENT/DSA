class Solution {
    public int minMen(int arr[]) {
        // code here
        int n = arr.length; 
        List<int[]> intervals = new ArrayList<>();
        // Step 1: Convert workers into intervals 
        for (int i = 0; i < n; i++) { 
            if (arr[i] != -1) { 
                int left = Math.max(0, i - arr[i]); 
                int right = Math.min(n - 1, i + arr[i]); 
                intervals.add(new int[]{left, right}); 
                
            } 
            
        } 
        // Step 2: Sort intervals by starting point 
        intervals.sort((a, b) -> a[0] - b[0]);
        // Step 3: Greedy covering 
        int workers = 0; 
        int idx = 0; 
        int currentEnd = 0; 
        int farthest = 0; 
        while (currentEnd < n) { 
            boolean found = false;
            // Find the interval that starts <= currentEnd and extends farthest 
            while (idx < intervals.size() && intervals.get(idx)[0] <= currentEnd) { 
                farthest = Math.max(farthest, intervals.get(idx)[1] + 1); 
                idx++; 
                found = true; 
                
            } 
            if (!found) 
            return -1; 
            // No interval can extend coverage 
            workers++; 
            currentEnd = farthest; 
            if (currentEnd >= n){
                return workers; 
            } 
            
            
        } 
        return -1;
    }
}