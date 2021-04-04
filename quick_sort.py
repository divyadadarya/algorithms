def partition(arr, lb, ub):
    
    pivot = arr[lb]
    left = lb
    right = ub
    
    while (left < right):
        
        while (arr[left] <= pivot and left < len(arr)-1):
            left+=1
            
        while (arr[right] > pivot and right > 0):
            right-=1
            
        if left < right:
            temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            
    temp = arr[lb]
    arr[lb] = arr[right]
    arr[right] = temp
    
    return right

def quickSort(arr, lb, ub):

	if lb < ub:
		index = partition(arr, lb, ub)

		quickSort(arr, lb, index-1 )
		quickSort(arr, index+1, ub)

arr = [10, 1, 67, 20, 56, 34, 43, 90, 54, 8, 0]
n = len(arr)

quickSort(arr, 0, n-1)

for i in range(0, n):
	print(arr[i], end = " ")