import java.util.*;

class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class Main{

	private static Node construct(int[] inorder, int start, int end, Map<Integer, Integer> map){
		if(start > end){
			return null;
		}

		int index = start;
		for(int i = start + 1; i <= end; i++){
			if(map.get(inorder[i]) < map.get(inorder[index])){
				index = i;
			}
		}

		Node root = new Node(inorder[index]);

		//left subtree
		root.left = construct(inorder, start, index - 1, map);

		//right subtree
		root.right = construct(inorder, index + 1, end, map);

		return root;
	}

	private static Node construct(int[] inorder, int[] level){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < level.length; i++){
			map.put(level[i], i);
		}

		return construct(inorder, 0, inorder.length - 1, map);
	}

	//inorder traversal
	public static void printInOrder(Node root){
		if(root != null){
			printInOrder(root.left);
			System.out.println(root.value);
			printInOrder(root.right);
		}
	}

	public static void main(String[] args){

		int[] inorder = {1, 5, 6, 7, 9, 12, 14};
		int[] level = {9, 5, 12, 1, 6, 14, 7};

		Node root = construct(inorder, level);

		System.out.println("Inorder Traversal of constructed tree :");
		printInOrder(root);
	}
}