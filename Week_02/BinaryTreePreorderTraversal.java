package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}

	private void preOrder(TreeNode root, List<Integer> res) {
		if (null==root)return;
		res.add(root.val);
		preOrder(root.left,res);
		preOrder(root.right,res);
    
	}

}
