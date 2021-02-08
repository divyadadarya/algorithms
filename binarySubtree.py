class Node:
    
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        
    def inorderTraversal(self, root):
        res = []
        if root:
            res = self.inorderTraversal(root.left)
            res.append(root.data)
            res+= self.inorderTraversal(root.right)
        
        return res

    def preorderTraversal(self, root):
        res = []
        if root:
            res.append(root.data)
            res += self.preorderTraversal(root.left)
            res += self.preorderTraversal(root.right)
            
        return res
    
    def listToString(l):
        string = ""
        for i in l:
            string += str(i)
            
        return string
    
    def main(tree, sub):

        if sub == None:
    	    return True
      
        if tree == None:
            return False

        l1 = tree.inorderTraversal(tree)
        l2 = sub.inorderTraversal(sub)

        if Node.listToString(l2) not in Node.listToString(l1):
            return False

        l3 = tree.preorderTraversal(tree)
        l4 = sub.preorderTraversal(sub)
    
        if Node.listToString(l4) in Node.listToString(l3):
            return True
        else:
            return False


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