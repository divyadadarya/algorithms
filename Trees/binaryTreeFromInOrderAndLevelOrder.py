class Node:
	def __init__(self, value):
		self.left = None
		self.right = None
		self.val = value

def printInOrder(node):
	if node == None:
		return

	printInOrder(node.left)
	print(node.val, " ")
	printInOrder(node.right)

def construct1(inorder, start, end, dict):
	if start > end:
		return None

	index = start
	for i in range(start+1, end+1):
		if dict[inorder[i]] < dict[inorder[index]]:
			index = i

	root = Node(inorder[index])

	root.left = construct1(inorder, start, index - 1, dict)

	root.right = construct1(inorder, index + 1, end, dict)

	return root

def construct(inorder, level):
	dict = {}
	for i in range(0, len(level)):
		dict[level[i]] = i

	return construct1(inorder, 0, len(inorder) - 1, dict)

inorder = [1, 5, 6, 7, 9, 12, 14]
level = [9, 5, 12, 1, 6, 14, 7]

root = construct(inorder, level);

print("Inorder Traversal of constructed tree :")
printInOrder(root)