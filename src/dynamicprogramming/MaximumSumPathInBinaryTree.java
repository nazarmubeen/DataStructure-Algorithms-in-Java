package dynamicprogramming;

import treeproblems_interviewBit.TreeNode;

/// same value can be used by multiple recursive calls.
class Res {
  int val;
}

public class MaximumSumPathInBinaryTree {
	 static TreeNode root;
	public static void main(String[] args)
	{
		MaximumSumPathInBinaryTree obj=new MaximumSumPathInBinaryTree();
		TreeNode node=null;
		obj.maxPathSum(node);
	}
	

	
	
 
    // A utility function to find the maximum sum between any
    // two leaves.This function calculates two values:
    // 1) Maximum path sum between two leaves which is stored
    //    in res.
    // 2) The maximum root to leaf path sum which is returned.
    // If one side of root is empty, then it returns INT_MIN
    int maxPathSumUtil(TreeNode node, Res res) {
 
        // Base cases
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.val;
 
        // Find maximum sum in left and right subtree. Also
        // find maximum root to leaf sums in left and right
        // subtrees and store them in ls and rs
        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);
 
        // If both left and right children exist
        if (node.left != null && node.right != null) {
 
            // Update result if needed
            res.val = Math.max(res.val, ls + rs + node.val);
 
            // Return maxium possible value for root being
            // on one side
            return Math.max(ls, rs) + node.val;
        }
 
        // If any of the two children is empty, return
        // root sum for root being on one side
        return (node.left == null) ? rs + node.val
                : ls + node.val;
    }
 
    // The main function which returns sum of the maximum
    // sum path between two leaves. This function mainly
    // uses maxPathSumUtil()
    int maxPathSum(TreeNode node)
    {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSumUtil(root, res);
        return res.val;
    }
	
	
	
	
	
}

