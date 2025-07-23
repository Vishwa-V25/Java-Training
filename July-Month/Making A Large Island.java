You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

 
Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.

Solution

class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int idx = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, idx);
                    map.put(idx, size);
                    idx++;
                }
            }
        }

        int maxisland = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int possible = 1;
                    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n){
                           continue;
                        } 
                        int id = grid[nx][ny];
                        if (id > 1 && set.add(id)) {
                            possible += map.get(id);
                        }
                    }
                    maxisland = Math.max(maxisland, possible);
                }
            }
        }

        if (maxisland == 0) {
            return n * n;
        }

        return maxisland;
    }

    private int dfs(int[][] grid, int i, int j, int idx) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = idx;
        int size = 1;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            size += dfs(grid, i + dir[0], j + dir[1], idx);
        }
        return size;
    }
}
