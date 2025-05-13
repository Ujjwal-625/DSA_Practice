class Solution {
    public void rotate(int[][] matrix) {
        int [][] transpose=new int[matrix.length][matrix.length];
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transpose[j][i]=matrix[i][j];
            }
        }

        //now trying to reverse the rows
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=transpose[i][n-j-1];
            }
        }
    }
}