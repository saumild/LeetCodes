class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        long maxh = Math.max(horizontalCuts[0], h - horizontalCuts[n-1]);
        long maxw = Math.max(verticalCuts[0], w - verticalCuts[m-1]);
        
        for(int i = 1; i< n; i++){
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for(int i = 1; i< m; i++){
            maxw = Math.max(maxw, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        return (int)((maxh*maxw)%(1000000007));
    }
}