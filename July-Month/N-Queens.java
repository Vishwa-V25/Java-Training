N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
  
Example 2:
Input: n = 1
Output: [["Q"]]
 
Constraints:
1 <= n <= 9

Solution
 
class Solution {
    private void helper(int row,char[][] dp,boolean[] colArr,boolean[] upArr,boolean[] downArr,List<List<String>> result,int N){
        if(row==N){
            List<String> curr = new ArrayList<>();
            for (char[] rows : dp) {
                curr.add(new String(rows));
            }
            result.add(curr);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (colArr[col] || upArr[row+col] || downArr[row-col+N-1]) continue;
            dp[row][col]='Q';
            colArr[col]=true;
            upArr[row+col]=true;
            downArr[row-col+N-1]=true;
            helper(row+1, dp, colArr, upArr, downArr, result, N);
            dp[row][col]='.';
            colArr[col]=false;
            upArr[row+col]=false;
            downArr[row-col+N-1]=false;
        }
    }
    public List<List<String>> solveNQueens(int N) {
        char[][] dp=new char[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],'.');
        }
        boolean[] colArr=new boolean[N];
        boolean[] upArr=new boolean[(2*N)-1];
        boolean[] downArr=new boolean[(2*N)-1];
        List<List<String>> result=new ArrayList<>();
        helper(0, dp, colArr, upArr, downArr, result, N);
        return result;
    }
}
