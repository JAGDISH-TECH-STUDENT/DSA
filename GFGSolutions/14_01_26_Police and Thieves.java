import java.util.*;
class Solution {
    public int catchThieves(char[] arr, int k) {
        List<Integer> p=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        int c=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='P'){
                p.add(i);
            }
            else{
                t.add(i);
            }
        }
        int pc=0,tc=0;
        
        while(pc<p.size() && tc<t.size()){
            if(Math.abs(p.get(pc)-t.get(tc))<=k){
                c++;
                pc++;
                tc++;
            }
            else if(t.get(tc)<p.get(pc)){
                tc++;
            }
            else{
                pc++;
            }
        }
        return c;
    }
}

