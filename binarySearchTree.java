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
	private Node insertInBST(Node node, int value){

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

	public void insert(int value){
		this.root = insertInBST(this.root, value);
	}


	//SEARCH
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

	public Node search(int value){
		return searchInBST(this.root, value);
	}


	//DELETE
	private int minValue(Node right){
		int min = right.value;

		//leftmost value
		while(right.left != null){
			min = right.left.value;
			right = right.left;
		}

		return min;
	}

	private Node deleteFromBST(Node node, int value){
		if(node == null)
			return node;

		if(value < node.value){
			node.left = deleteFromBST(node.left, value);
		}

		else if(value > node.value){
			node.right = deleteFromBST(node.right, value);
		} 

		else{
			if(node.left == null)
				return node.right;

			if(node.right == null)
				return node.left;

			node.value = minValue(node.right);
			node.right = deleteFromBST(node.right, node.value);
		}

		return node;
	}

	public void delete(int value){
		deleteFromBST(this.root, value);
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

		System.out.println("Deleting 13 : ");
		tree.delete(13);
		tree.printInOrder(tree.root);
	}
}