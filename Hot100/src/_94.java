
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @Package:  
 * @author: cqzeng   
 * @date: 2021年4月26日 下午10:17:15
 */
public class _94 {
	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	  	public TreeNode(int val) {
	    this.val = val;
	    }
	}
    /**
     * 中序遍历
     * 
     * @param root TreeNode类 
     * @return int整型ArrayList
     */
	public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        
        List<Integer> leftList = inorderTraversal(root.left);
        if (!leftList.isEmpty()) {
            list.addAll(leftList);
        }
        list.add(root.val);
        List<Integer> rightList = inorderTraversal(root.right);
        if (!rightList.isEmpty()) {
            list.addAll(rightList);
        }
        return list;
    }
    
    private int nodeIndex;
    public TreeNode createTree(char[] values) {
    	nodeIndex = 0;
    	return subCreateTree(values, 0);
    }
    private TreeNode subCreateTree(char[] values, int i) {
    	if (i >= values.length || values[i] == '#') {
    		return null;
    	}
    	TreeNode node = new TreeNode(values[i] - '0');
    	node.left = subCreateTree(values, ++nodeIndex);
    	node.right = subCreateTree(values, ++nodeIndex);
    	return node;
    }
    
    public static void main(String[] args) {
    	_94 s = new _94();
    	TreeNode root = s.createTree(new char[] {'1', '#', '2', '3', '4'});
    	System.out.println(s.inorderTraversal(root));
    }
}
