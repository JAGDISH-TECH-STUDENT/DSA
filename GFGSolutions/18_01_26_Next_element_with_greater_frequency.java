class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> l = new ArrayList<>(Collections.nCopies(n, -1));
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && freq.get(stack.peek()) <= freq.get(arr[i])) { 
                stack.pop(); 
                
            }
            if(!stack.isEmpty()){
                l.set(i,stack.peek());
            }
            stack.push(arr[i]);
            
        }
        return l;
    }
}