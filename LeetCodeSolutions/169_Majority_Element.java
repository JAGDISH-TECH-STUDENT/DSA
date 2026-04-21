class Solution {
    public int majorityElement(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>max){
                max=count;
                n=nums[i];
            }
        }
        return n;
        
    }
}