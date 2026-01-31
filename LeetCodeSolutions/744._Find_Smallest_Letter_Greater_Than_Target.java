class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0,h=letters.length-1;
        boolean f=false;
        char ans=letters[0];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(letters[mid]>target){
                h=mid-1;
                f=true;
            }
            else{
                l=mid+1;
            }
        }
        if(f){
            return letters[l];
        }
        else{
            return ans;
        }
    }
}