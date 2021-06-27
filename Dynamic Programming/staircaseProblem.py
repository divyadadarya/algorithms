#TOP-DOWN
def numberOfWays(n, k, arr):
	if n == 0:
		arr[n] = 1
		return 1

	if n < 0:
		return 0

	if arr[n] != -1:
		return arr[n]

	arr[n] = 0

	for i in range(1, k+1):
		arr[n] = arr[n] + numberOfWays(n-i, k, arr)

	return arr[n]

#BOTTOM-UP
def waysBottomUp(n, k):

	arr = [0] * (n+1)

	arr[0] = 1

	for i in range(1, n+1):
		for j in range(1, k+1):
			if i - j >= 0:
				arr[i] = arr[i] + arr[i - j]

	return arr[n]

n = 10
k = 10
arr = [-1] * (n+1)

ways = numberOfWays(n, k, arr)
noOfWays = waysBottomUp(n, k)

print(ways)
print(noOfWays)