class Solution {
    //Every n elements → we move to next row
    //Every n elements → we move to next row
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        int left=0;
        int right=matrix.length*matrix[0].length-1;
        while(right>=left)
        {
            int mid=(left+right)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]>target)
            {
                right=mid-1;
            }
            else
            {
               left=mid+1;
            }
        }
        return false;
    }
}
