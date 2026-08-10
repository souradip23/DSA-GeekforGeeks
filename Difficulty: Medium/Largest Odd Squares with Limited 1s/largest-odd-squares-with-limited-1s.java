import java.util.*;

class Solution {
	
	// Returns number of 1s in rectangle
	// (r1, c1) -> (r2, c2)
	private int getSum(int[][] prefix, int r1, int c1, int r2, int c2) {
		return prefix[r2 + 1][c2 + 1]
		- prefix[r1][c2 + 1]
		- prefix[r2 + 1][c1]
		+ prefix[r1][c1];
	}
	
	public ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
		
		int n = mat.length;
		int m = mat[0].length;
		
		// --------------------------------
		// Step 1: Build 2D Prefix Sum
		// --------------------------------
		
		int[][] prefix = new int[n + 1][m + 1];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				prefix[i + 1][j + 1] =
				mat[i][j]
				+ prefix[i][j + 1]
				+ prefix[i + 1][j]
				- prefix[i][j];
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		// --------------------------------
		// Step 2: Process each query
		// --------------------------------
		
		for (int[] q : queries) {
			
			int i = q[0];
			int j = q[1];
			
			// Maximum possible radius
			int maxRadius = Math.min(
			Math.min(i, n - 1 - i),
			Math.min(j, m - 1 - j)
			);
			
			int low = 0;
			int high = maxRadius;
			
			// -1 means no valid square exists
			int best = -1;
			
			// --------------------------------
			// Step 3: Binary Search
			// --------------------------------
			
			while (low <= high) {
				
				int mid = low + (high - low) / 2;
				
				int top = i - mid;
				int bottom = i + mid;
				int left = j - mid;
				int right = j + mid;
				
				int ones = getSum(
				prefix,
				top,
				left,
				bottom,
				right
				);
				
				if (ones <= k) {
					
					// Current square is valid
					best = mid;
					
					// Try a larger square
					low = mid + 1;
					
				} else {
					
					// Too many 1s
					high = mid - 1;
				}
			}
			
			// radius -> side length
			int side = 2 * best + 1;
			
			ans.add(side);
		}
		
		return ans;
	}
}
