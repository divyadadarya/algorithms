class BinarySearchTree:
	class Node:
		def __init__(self, value):
			self.left = None
			self.right = None
			self.val = value



	def __init__(self):
		self.root = None

	def printInOrder(self, node):
		if node != None:
			self.printInOrder(node.left)
			print(node.val, " ")
			self.printInOrder(node.right)

	#INSERT
	def insertInBST(self, node, value):
		if node == None:
			return self.Node(value)

		if value < node.val:
			node.left = self.insertInBST(node.left, value)

		if value > node.val:
			node.right = self.insertInBST(node.right, value)

		return node
		
	def insert(self, value):
		self.root = self.insertInBST(self.root, value)

	#SEARCH
	def searchInBST(self, node, value):
		if node == None or node.val == value:
			return node

		if value < node.val:
			return self.searchInBST(node.left, value)

		else:
			return self.searchInBST(node.right, value)

	def search(self, value):
		return self.searchInBST(self.root, value)

	#DELETE
	def minValue(self, right):
		minVal = right.val

		while right.left != None:
			minVal = right.left.val
			right = right.left

		return minVal

	def deleteFromBST(self, node, value):
		if node == None:
			return node

		if value < node.val:
			node.left = self.deleteFromBST(node.left, value)

		elif value > node.val:
				node.right = self.deleteFromBST(node.right, value)

		else:
			if node.left == None:
				return node.right

			if node.right == None:
				return node.left

			node.value = self.minValue(node.right)
			node.right = self.deleteFromBST(node.right, node.value)

		return node

	def delete(self, value):
		self.deleteFromBST(self.root, value)

tree = BinarySearchTree()

tree.insert(13)
tree.insert(15)
tree.insert(7)
tree.insert(8)
tree.insert(5)
tree.insert(2)
tree.insert(6)
tree.insert(14)
tree.insert(16)

tree.printInOrder(tree.root)

print("Search in BST : ")
print(tree.search(7).val)

print("Deleting 13 : ")
tree.delete(13)
tree.printInOrder(tree.root)