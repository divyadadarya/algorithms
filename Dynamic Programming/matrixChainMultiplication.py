#BOTTOM-UP
def mcmBottomUp(seq, n):
	rows, cols = (n, n)
	arr = []
	for i in range(rows):
		col = []
		for j in range(cols):
			col.append(-1)
		arr.append(col)

	for i in range(len(arr)):
		arr[i][i] = 0

	for l in range(2, n):
		for i in range(1, n-l+1):
			j = i + l - 1

			if j == n:
				continue

			minOps = float('inf')

			for k in range(i, j):
				ops = arr[i][k] + arr[k+1][j] + (seq[i-1] * seq[k] * seq[j])
				minOps = min(minOps, ops)
				arr[i][j] = minOps

	return arr[1][n-1]

#TOP-DOWN
def mcmTopDown(seq, i, j, arr):
	if i == j:
		arr[i][j] = 0
		return arr[i][j]

	if arr[i][j] >= 0:
		return arr[i][j]

	minOps = float('inf')

	for k in range(i, j):
		ops = mcmTopDown(seq, i, k, arr) + mcmTopDown(seq, k+1, j, arr) + (seq[i-1] * seq[k] * seq[j])
		minOps = min(minOps, ops)

	arr[i][j] = minOps
	return arr[i][j]

#RECURSION
def mcm(seq, i, j):
	if i == j:
		return 0

	minOps = float('inf')

	for k in range(i, j):
		ops = mcm(seq, i, k) + mcm(seq, k+1, j) + (seq[i-1] * seq[k] * seq[j])
		minOps = min(minOps, ops)

	return minOps

seq = [4, 3, 2, 1, 5]
n = len(seq)

rows, cols = (n, n)
dp = []
for i in range(rows):
	col = []
	for j in range(cols):
		col.append(-1)
	dp.append(col)

minOperations = mcm(seq, 1, n-1)
minOperationsTopDown = mcmTopDown(seq, 1, n-1, dp)
minOperationsBottomUp = mcmBottomUp(seq, n)

print(minOperations)
print(minOperationsTopDown)
print(minOperationsBottomUp)