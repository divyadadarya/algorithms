def merge(arr, l, m, u):
    
    n1 = m - l + 1
    n2 = u - m
    
    left = [0] * n1
    right = [0] * n2

    for i in range(0, n1):
    	left[i] = arr[l + i]

    for j in range(0, n2):
        right[j] = arr[m + 1 + j]
    
    i = 0 
    j = 0
    k = l

    while (i < n1 and j < n2):
        if (left[i] <= right[j]):
            arr[k] = left[i]
            i += 1
        
        else:
            arr[k] = right[j]
            j += 1
            
        k += 1
            
    while i < n1:
        arr[k] = left[i]
        i += 1
        k += 1
    
    while j < n2:
        arr[k] = right[j]
        j += 1
        k += 1

def mergeSort(arr, l, u):

	if l < u:

		m = (l + u) // 2

		mergeSort(arr, l, m)
		mergeSort(arr, m+1, u)
        
		merge(arr, l, m, u)

arr = [11, 6, 3, 9, 14, 66, 2]
n = len(arr)

mergeSort(arr, 0, n-1)

for i in range(0, n):
	print(arr[i], end = " ")