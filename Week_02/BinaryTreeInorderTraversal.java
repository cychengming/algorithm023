package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

	private void inorder(TreeNode root, List<Integer> res) {
		//�ݹ���ֹ����
		if (root ==null)return;
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);		
	}
    
}
