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
		this.root = insertInBST(this.root, value);
	}

	private Node insertBST(Node node, int value){

		if(node == null)
			return new Node(value);

		if(value < node.value){
			node.left = insertInBST(node.left, value);
		}

		else if(value > node.value){
			node.right = insertInBST(node.right, value);
		}

		return node;
	}

	//SEARCH
	public Node search(int value){
		return searchInBST(this.root, value);
	}

	private Node searchInBST(Node node, int value){

		if(node == null || node.value == value)
			return node;

		if(value < node.value){
			return searchInBST(node.left, value);
		}

		else{
			return searchInBST(node.right, value);
		}
	}
}

class Main{

	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(13);
		tree.insert(15);
		tree.insert(7);

		tree.printInOrder(tree.root);

		System.out.println(tree.search(7).value);
	}
}