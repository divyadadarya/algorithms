class Main{

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
			System.out.println(node.value + " ");
			printInOrder(node.right);
		}
	}

}