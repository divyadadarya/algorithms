def arrayProductSum(list, depth):

	s = 0

    if l == []:
        return ""
    else:
  	    for i in l:
		    if isinstance(i, list):
			    s+= main(i, depth + 1)
		    else:
			    s+= i

    return s*depth


l = [1, 2, [2,3], 6, [[2,3],1], 7]
output = arrayProductSum(l, 1)
print(output)