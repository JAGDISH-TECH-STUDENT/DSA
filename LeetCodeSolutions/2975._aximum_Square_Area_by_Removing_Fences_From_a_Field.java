class Solution {
    static final int MOD = 1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
         // add borders
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 1] = hFences[i];
        }

        v[0] = 1;
        v[v.length - 1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        // store all horizontal distances
        HashSet<Integer> hDist = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hDist.add(h[j] - h[i]);
            }
        }

        long maxSide = -1;

        // check vertical distances against horizontal set
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int dist = v[j] - v[i];
                if (hDist.contains(dist)) {
                    maxSide = Math.max(maxSide, dist);
                }
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((1L*maxSide * maxSide) % MOD);
    }
}
