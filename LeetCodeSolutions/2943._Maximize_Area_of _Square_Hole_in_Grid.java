class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
       Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hstrip = 1, vstrip = 1;

        int currstrip = 1;
        int prevbar = hBars[0];

        for(int i=1; i<hBars.length; i++) {
            if(hBars[i] == prevbar+1) {
                currstrip++;
                hstrip = Math.max(currstrip, hstrip);
            } else {
                currstrip = 1;
            }
            prevbar = hBars[i];
        }

        // vertical stripe calculation
        prevbar = vBars[0];
        currstrip = 1;
        for(int i=1; i<vBars.length; i++) {
            if(vBars[i] == prevbar+1) {
                currstrip++;
                vstrip = Math.max(currstrip, vstrip);
            } else {
                currstrip = 1;
            }
            prevbar = vBars[i];
        }

        // hstrip, vstrip 

        int min = Math.min(hstrip, vstrip)+1;
        return min*min;
    }
}