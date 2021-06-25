class Node{
	int value;
	Node left;
	Node right;

	public Node(int value){
		this.value = value;
	}

	public void printInOrder(Node node){
		if(node == null)
			return;

		printInOrder(node.left);
		System.out.println(node.value + " ");
		printInOrder(node.right);
	}

	public void invertTree(Node node){
		if(node == null){
			return;
		}

		//swap
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

		invertTree(node.left);
		invertTree(node.right);
	}
}

class Main{

	public static void main(String[] args){

		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		root.left.left.right = new Node(6);

		root.invertTree(root);
		root.printInOrder(root);
	}
}