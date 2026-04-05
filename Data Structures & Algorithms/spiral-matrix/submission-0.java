class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int srow=0;
        int erow=matrix.length-1;
        int scol=0;
        int ecol=matrix[0].length-1;
        List <Integer> result=new ArrayList<>();
        while(srow<=erow && scol<=ecol)
        {
        //top
            for(int j=scol;j<=ecol;j++)
            {
                result.add(matrix[srow][j]);
            }
       //right
             for(int j=srow+1;j<=erow;j++)
            {
                result.add(matrix[j][ecol]);
            }
//bottom
             for(int j=ecol-1;j>=scol;j--)
            {
                if(srow==erow)
                break;
                result.add(matrix[erow][j]);
            }
//left
             for(int j=erow-1;j>=srow+1;j--)
            {
                if(scol==ecol)
                break;
                result.add(matrix[j][scol]);
            }
            srow++;scol++;ecol--;erow--;

        }
        return result;
       
    }
}
