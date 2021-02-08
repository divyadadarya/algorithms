class Node():

  def _init_(self, data):

    self.left = None
    self.right = None
    self.data = data

  def inorderTraversal(self, root):
    res = []
    if root:
        res = self.inorderTraversal(root.left)
        res.append(root.data)
        res = res + self.inorderTraversal(root.right)
    return res

  def PreorderTraversal(self, root):
    res = []
    if root:
      res.append(root.data)
      res = res + self.PreorderTraversal(root.left)
      res = res + self.PreorderTraversal(root.right)
    return res

  def listToString(s):   
    str1 = ""  
    for ele in s:  
    	str1 += str(ele)   
    return str1  

  def main(tree, sub):

    if sub == None:
    	return True
      
    if tree == None:
      return False

    l1 = root.inorderTraversal(root)
    l2 = root2.inorderTraversal(root2)

    if Node.listToString(l1) != Node.listToString(l2):
      return False

    l3 = root.PreorderTraversal(root)
    l4 = root2.PreorderTraversal(root2)
    
    return Node.listToString(l3) == Node.listToString(l4)



root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)

root2 = Node(4)
root2.left = Node(5)
root2.right = Node(6)

output = Node.main(root, root2)
print(output)