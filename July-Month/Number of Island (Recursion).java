Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Solution
 
import java.util.*;
public class Solution {
    
    public static void helper(int[][] arr,int r,int c){
        if(r<0 || r>=arr.length ||c<0||c>=arr[0].length || arr[r][c]!=1){
            return ;
        }
         arr[r][c]=2;
         helper(arr,r-1,c);
         helper(arr,r,c-1);
         helper(arr,r+1,c);
         helper(arr,r,c+1);
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int row=sc.nextInt();
    int col=sc.nextInt();
    int[][] arr = new int[row][col];
    for(int r=0;r<row;r++){
        for(int c=0;c<col;c++){
            arr[r][c]=sc.nextInt();
        }
    }
    int count=0;
    for(int r=0;r<row;r++){
        for(int c=0;c<col;c++){
            if(arr[r][c]==1){
                count++;
                helper(arr,r,c);
            }
        }
    }
    System.out.print(count);
    }
}
