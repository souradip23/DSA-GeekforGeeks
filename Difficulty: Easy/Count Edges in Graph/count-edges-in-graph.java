class Solution {
  Set<int[]> set = new HashSet<>();
  public int countEdges(ArrayList<ArrayList<Integer>> adj) {
    // code here
    int node = 0;
    int ans = 0;
    for (ArrayList<Integer> list : adj) {
      for (int i : list) {
        if (set.contains(new int[] {i, node}) ||
            set.contains(new int[] {node, i})) {
          continue;
        } else {
          ans++;
          set.contains(new int[] {node, i});
        }
      }
      node++;
    }
    return ans / 2;
  }
}