package interviewbit.treeproblems_interviewBit;

public class LeastCommonAncestor {
	TreeNode root;
    static boolean v1 = false, v2 = false;
    
	public static void main(String[] args)
	{
		LeastCommonAncestor obj=new LeastCommonAncestor();
		TreeNode node=new TreeNode(1);
		System.out.println();
		node.left=new TreeNode(2);
		node.right=new TreeNode(5);
		node.left.left=new TreeNode(-1);
		node.left.right=new TreeNode(-1);
		node.right.right=new TreeNode(-1);
		node.right.left=new TreeNode(4);
		node.right.left.left=new TreeNode(-1);
		node.right.left.right=new TreeNode(8);
		System.out.println(obj.lca(node, 1, 1));
	}
	
	
	public int lca(TreeNode a, int val1, int val2) {
		
		  // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;
        
        if(a.left==null && a.right==null && val1==a.val && val2==a.val)
		{
		    return a.val;
		}
        // Find lca of n1 and n2 using the technique discussed above
        TreeNode lca = findLCAUtil(root, val1, val2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca.val;
 
        // Else return NULL
        return -1;
	}
	
	// This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
	TreeNode findLCAUtil(TreeNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.val == n1)
        {
            v1 = true;
            return node;
        }
        if (node.val == n2)
        {
            v2 = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCAUtil(node.left, n1, n2);
        TreeNode right_lca = findLCAUtil(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
	
}
