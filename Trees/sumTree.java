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

	public int convertToSumTree(Node node){
		if(node == null){
			return 0;
		}

		int oldValue = node.value;

		int leftTreeSum = convertToSumTree(node.left);
		int rightTreeSum = convertToSumTree(node.right);

		node.value = leftTreeSum + rightTreeSum;

		return oldValue + node.value;
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