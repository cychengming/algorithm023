package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * 
 * 方法和二叉树的前序遍历一直，只是相对于左右节点变为多个子节点
 * 
 * 
 */
public class NaryTreePreOrderTraversal {
  class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
 
   public List<Integer> preorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }

	private void preOrder(Node root, List<Integer> res) {
		if (null==root)return;
		res.add(root.val);
		for (Node child:root.children){
			preOrder(child,res);		
		}

	}
	
	
}


