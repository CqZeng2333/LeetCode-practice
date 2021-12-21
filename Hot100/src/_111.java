import java.util.LinkedList;
import java.util.Queue;
/**
 * 二叉树的最小深度
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:04:56
 */
public class _111 {
	
	 private class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
	 
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int step = 1;
		
		while(!queue.isEmpty()) {
			int qz = queue.size();
				for (int i = 0; i < qz; i++) {
				TreeNode temp = queue.poll();
				if (temp.left == null && temp.right == null) {
					return step;
				}
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			step++;
		}
		return step;
	}
}
