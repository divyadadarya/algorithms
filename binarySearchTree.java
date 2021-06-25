class BinarySearchTree{
	class Node{
		int value;
		Node left;
		Node right;

		public Node(int value){
			this.value = value;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree(){
		root = null;
	}

	public void printInOrder(Node node){
		if(node != null){
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}

	//INSERT
	public void insert(int value){
		this.root = insertBST(this.root, value);
	}

	private Node insertBST(Node node, int value){

		if(node == null)
			return new Node(value);

		if(value < node.value){
			node.left = insertBST(node.left, value);
		}

		else if(value > node.value){
			node.right = insertBST(node.right, value);
		}

		return node;
	}

	
}

class Main{

	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(13);
		tree.insert(15);
		tree.insert(7);

		tree.printInOrder(tree.root);
	}
}