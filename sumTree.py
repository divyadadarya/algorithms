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

def convertToSumTree(node):
	if node == None:
		return 0

	oldValue = node.val

	leftTreeSum = convertToSumTree(node.left)
	rightTreeSum = convertToSumTree(node.right)

	node.val = leftTreeSum + rightTreeSum

	return oldValue + node.val

root = Node(8)
root.left = Node(7)
root.right = Node(-4)
root.left.left = Node(3)
root.left.right = Node(-6)
root.right.left = Node(7)
root.right.right = Node(9)

convertToSumTree(root)
printInOrder(root)