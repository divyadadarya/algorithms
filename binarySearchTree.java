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

	public Node insert(Node node, int value){

		if(node == null)
			return new Node(value);

		if(value < node.value){
			node.left = insert(node.left, value);
		}

		else if(value > node.value){
			node.right = insert(node.right, value);
		}

		return node;
	}
}

class Main{

	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = tree.new Node(13);

		tree.insert(tree.root, 15);
		tree.insert(tree.root, 7);

		tree.printInOrder(tree.root);
	}
}