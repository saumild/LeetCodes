class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor)
            return image;
        image[sr][sc] = newColor;
        return flood(image, sr,sc,color);
    }
    
    public int[][] flood(int[][] image, int sr, int sc,int color) {
        
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; 
        for(int i =0 ;i< 4;i++){
            int m = sr + dir[i][0];
            int n = sc + dir[i][1];
            if(m>=0 && m<image.length && n >= 0 && n<image[0].length){
                if(image[m][n] == color){
                    image[m][n] = image[sr][sc];
                    image = flood(image,m,n,color);
                }
            }
        }
        
        return image;
    }
}