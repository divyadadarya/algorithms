import math   

def getPivotValue(arr, low, high):

	n = len(arr)

	if high-low+1 <= 9:
		arr.sort()

		return arr[int(n / 2)]

	m = int(math.ceil((high-low+1)/5))
	median = [0] * m
	medianIndex = 0

	while high >= low:
		p = min(5, high-low+1)
		temp = [0] * p

		i = 0
		while(i < len(temp) and low <= high):
			temp[i] = arr[low]
			low+= 1
			i+=1

		temp.sort()

		median[medianIndex] = temp[int(len(temp) / 2)]
		medianIndex+=1

	return getPivotValue(median, 0, len(median) - 1)

def partition(arr, low, high):

	pivot = getPivotValue(arr, low, high)

	while low < high:
		while arr[low] <= pivot:
			low+=1

		while arr[high] > pivot:
			high-=1

		if low < high :
			arr[low], arr[high] = arr[high], arr[low]

	return high

def findMedianUtil(arr, mid, low, high):
	n = partition(arr, low, high)

	length = n-low+1

	if length == mid:
		return arr[n]

	if length > mid:
		return findMedianUtil(arr, mid, low, n-1)

	else:
		return findMedianUtil(arr, mid-length, n+1, high)

def findMedian(arr):
	n = len(arr)

	mid = int(n / 2)

	median = findMedianUtil(arr, mid+1, 0, n-1)

	print("Median = " ,median)

arr = [25, 24, 33, 39, 3, 18, 19, 31, 23, 49, 45, 16, 1, 29, 40, 22, 15, 20, 24, 4, 13, 34]

findMedian(arr)