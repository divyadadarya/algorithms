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
}

class Main{

	public static void main(String[] args){

		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(-4);
		root.left.left = new Node(3);
		root.left.right = new Node(-6);
		root.right.left = new Node(7);
		root.right.right = new Node(9);

		root.convertToSumTree(root);
		root.printInOrder(root);
	}
}