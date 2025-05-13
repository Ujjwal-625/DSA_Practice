class Solution {
    public void setZeroes(int[][] matrix) {
        int row []=new int[matrix.length];
        int col []=new int [matrix[0].length];
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            row[i]=-1;
        }
         for(int i=0;i<c;i++){
            col[i]=-1;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    row[i]=0;
                    col[j]=0;
                }
            }
        }

         for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               if(row[i]==0 || col[j]==0){
                   matrix[i][j]=0;
               }
            }
        }
        
    }
}