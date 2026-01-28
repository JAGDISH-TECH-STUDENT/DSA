class Solution {
    public int countSubset(int[] arr, int k) {
        // code here
       int n = arr.length;
       // Split into two halves 
       int mid = n / 2; 
       List<Integer> leftSums = new ArrayList<>(); 
       List<Integer> rightSums = new ArrayList<>();
       // Generate subset sums for both halves 
       generateSums(arr, 0, mid, leftSums, 0); 
       generateSums(arr, mid, n, rightSums, 0); 
       // Count frequencies of right sums 
       Map<Integer, Integer> rightFreq = new HashMap<>(); 
       for (int sum : rightSums) { 
           rightFreq.put(sum, rightFreq.getOrDefault(sum, 0) + 1); 
           
       } // For each left sum, find complement in right 
       int count = 0; 
       for (int sum : leftSums) { 
           int need = k - sum; count += rightFreq.getOrDefault(need, 0); 
           
       } return count; 
        
    }
    
    public void generateSums(int[] arr, int start, int end, List<Integer> sums, int currentSum) { 
            if (start == end) { 
                sums.add(currentSum); 
                return; 
                
            } // Exclude current element 
            generateSums(arr, start + 1, end, sums, currentSum);
            // Include current element 
            generateSums(arr, start + 1, end, sums, currentSum + arr[start]); 
            
        }
}
