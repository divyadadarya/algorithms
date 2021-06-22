def maxSumSubArray(arr):
	localMax = arr[0]
	globalMax = arr[0]

	for i in range(1, len(arr)):
		localMax = max(localMax + arr[i], arr[i])

		globalMax = max(localMax, globalMax)

	return globalMax

arr = [-2, -1, 3, -2, 4, 3, -3, -2, 5]

maxSum = maxSumSubArray(arr)

print(maxSum)