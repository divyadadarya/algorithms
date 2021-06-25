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

def invertBinaryTree(node):
    if node == None:
        return

	#swap
    temp = node.left
    node.left = node.right
    node.right = temp
    
    invertBinaryTree(node.left)
    invertBinaryTree(node.right)

root = Node(8)
root.left = Node(7)
root.right = Node(4)
root.left.left = Node(3)
root.left.right = Node(6)
root.right.left = Node(7)
root.right.right = Node(9)
root.left.left.right = Node(6)

printInOrder(root)
print("---------------")

invertBinaryTree(root)
printInOrder(root)