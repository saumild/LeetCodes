class Solution {
    public String tictactoe(int[][] moves) {
       int i,arr[][]=new int[3][3];
        
        //storing moves
        for(i=0;i<moves.length;i++)
            if(i%2==0)
                arr[moves[i][0]][moves[i][1]]=1;
            else
                arr[moves[i][0]][moves[i][1]]=-1;
        
        //checking winner from rows and columns
        for(i=0;i<3;i++) {
            if(arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2])
                if(arr[i][0]==1)
                    return "A";
                else if(arr[i][0]==-1)
                    return "B";
            if(arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i])
                if(arr[0][i]==1)
                    return "A";
                else if(arr[0][i]==-1)
                    return "B";
        }
        
        //checking winner from main diagonal
        if(arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2])
            if(arr[0][0]==1)
                return "A";
            else if(arr[0][0]==-1)
                return "B";
        
        //checking winner from right diagonal
        if(arr[2][0]==arr[1][1]&&arr[1][1]==arr[0][2])
            if(arr[2][0]==1)
                return "A";
            else if(arr[2][0]==-1)
                return "B";
        
        if(moves.length<9)
            return "Pending";
        
        return "Draw";
        
    }
}