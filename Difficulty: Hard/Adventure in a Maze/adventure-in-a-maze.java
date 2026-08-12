class Solution {

    static final int MOD = 1000000007;

    public ArrayList<Integer> findWays(int[][] grid) {

        ArrayList<Integer> list = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;

        long[][] paths = new long[row][col];
        int[][] pathSum = new int[row][col];

        // -1 means this cell is unreachable
        for (int i = 0; i < row; i++) {
            Arrays.fill(pathSum[i], -1);
        }

        // Starting cell
        paths[0][0] = 1;
        pathSum[0][0] = grid[0][0];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                // Come from LEFT
                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)) {

                    paths[i][j] =
                        (paths[i][j] + paths[i][j - 1]) % MOD;

                    if (pathSum[i][j - 1] != -1) {
                        pathSum[i][j] = Math.max(
                            pathSum[i][j],
                            pathSum[i][j - 1] + grid[i][j]
                        );
                    }
                }

                // Come from TOP
                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)) {

                    paths[i][j] =
                        (paths[i][j] + paths[i - 1][j]) % MOD;

                    if (pathSum[i - 1][j] != -1) {
                        pathSum[i][j] = Math.max(
                            pathSum[i][j],
                            pathSum[i - 1][j] + grid[i][j]
                        );
                    }
                }
            }
        }

        // Number of paths
        list.add((int) paths[row - 1][col - 1]);

        // Maximum Adventure
        list.add(pathSum[row - 1][col - 1]==-1 ? 0 : pathSum[row - 1][col - 1]);

        return list;
    }
}