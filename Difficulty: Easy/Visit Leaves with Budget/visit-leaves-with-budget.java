/* Binary Tree Node Structure
class Node {
	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
	}
}
*/
class Solution {
	public void getLeafNodes(Node root, ArrayList<Integer> list, int level) {
		if (root == null)return;
		if (root.left == null && root.right == null) {
			list.add(level);
		}
		getLeafNodes(root.left, list, level + 1);
		getLeafNodes(root.right, list, level + 1);
		
	}
	public int getCount(Node root, int k) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		getLeafNodes(root, list, 1);
		Collections.sort(list);
		
		int sum = 0;
		int count = 0;
		
		for (int cost : list) {
			
			if (sum + cost > k) {
				break;
			}
			sum += cost;
			count++;
		}
		return count;
	}
}
