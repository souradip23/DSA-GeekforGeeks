class Solution {
public:
    int numberOfCells(int r, int c, int u, int d, vector<vector<char>> &mat) {

        int n = mat.size();
        int m = mat[0].size();

        if (mat[r][c] == '#')
            return 0;

        // visited[i][j] = maximum upward moves remaining
        vector<vector<int>> visited(n, vector<int>(m, -1));

        queue<vector<int>> q;

        q.push({r, c, u, d});
        visited[r][c] = u;

        while (!q.empty()) {

            auto x = q.front();
            q.pop();

            int i = x[0];
            int j = x[1];
            int ups = x[2];
            int downs = x[3];

            // Left
            if (j - 1 >= 0 && mat[i][j - 1] == '.') {

                int ni = i;
                int nj = j - 1;

                if (ups > visited[ni][nj]) {
                    visited[ni][nj] = ups;
                    q.push({ni, nj, ups, downs});
                }
            }

            // Right
            if (j + 1 < m && mat[i][j + 1] == '.') {

                int ni = i;
                int nj = j + 1;

                if (ups > visited[ni][nj]) {
                    visited[ni][nj] = ups;
                    q.push({ni, nj, ups, downs});
                }
            }

            // Up
            if (i - 1 >= 0 && mat[i - 1][j] == '.' && ups > 0) {

                int ni = i - 1;
                int nj = j;
                int newUps = ups - 1;

                if (newUps > visited[ni][nj]) {
                    visited[ni][nj] = newUps;
                    q.push({ni, nj, newUps, downs});
                }
            }

            // Down
            if (i + 1 < n && mat[i + 1][j] == '.' && downs > 0) {

                int ni = i + 1;
                int nj = j;
                int newDowns = downs - 1;

                if (ups > visited[ni][nj]) {
                    visited[ni][nj] = ups;
                    q.push({ni, nj, ups, newDowns});
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != -1)
                    cnt++;
            }
        }

        return cnt;
    }
};