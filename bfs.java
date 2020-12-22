
public class BinaryTree {
	public TreeNode root;
	public static class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public Object data;

		public TreeNode(Object data) {
			this.data = data;
			left = right = null;
		}
	}
}


public class PrintLevelsOfTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        /**
         * Binary Tree in our example, height = 2
         * 		1		(Root)
         * 	  2	  3		(Level 1)
         *       4  5   (Level 2)
         */
        binaryTree.root = new BinaryTree.TreeNode(1);
        binaryTree.root.left = new BinaryTree.TreeNode(2);
        binaryTree.root.right = new BinaryTree.TreeNode(3);
        binaryTree.root.left.left = new BinaryTree.TreeNode(4);
        binaryTree.root.right.left = new BinaryTree.TreeNode(5);

        printLevelsIteratively(binaryTree.root);
    }


    public static void printLevelsIteratively(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.peek();
    		if (node != null) {
    			System.out.print(node.data + " ");
    			queue.remove();

    			if (node.left != null)
    				queue.add(node.left);

    			if (node.right != null)
    				queue.add(node.right);
            }
        }
    }
}