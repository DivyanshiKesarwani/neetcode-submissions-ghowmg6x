class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>hs=new HashSet<>();

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
              char num = board[i][j];

                if(num == '.')
                    continue;

                String rowKey=num+"at row"+i;
                String colKey=num+"at col"+j;
                String boxKey=num+"at box"+"["+i/3+","+j/3+"]";
                if(hs.contains(rowKey) || hs.contains(colKey) || hs.contains(boxKey))
                {
                    return false;
                }

                hs.add(rowKey);
                hs.add(colKey);
                hs.add(boxKey);
            }

        }
        return true;
    }
}
