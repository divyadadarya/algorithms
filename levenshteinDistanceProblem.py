#BOTTOM-UP
def getLDistanceBottomUp(str1, str2, m, n, lDist):
	for i in range(0, m):
		lDist[0][i] = i

	for i in range(0, n):
		lDist[i][0] = i

	for i in range(1, m+1):
		for j in range(1, n+1):
			if str1[i-1] == str2[j-1]:
				lDist[i][j] = lDist[i-1][j-1]
			else:
				lDist[i][j] = 1 + min(lDist[i][j-1], lDist[i-1][j], lDist[i-1][j-1])

	return lDist[m][n]

#TOP-DOWN
def getLDistanceTopDown(str1, str2, m, n, lDist):
	if m == 0 or n == 0:
		return min(m, n)

	if lDist[m-1][n-1] >= 0:
		return lDist[m-1][n-1]

	ch1 = 1 + getLDistanceTopDown(str1, str2, m, n-1, lDist)
	ch2 = 1 + getLDistanceTopDown(str1, str2, m-1, n, lDist)
	
	if str1[m-1] == str2[n-1]:
		k = 0
	else:
		k = 1

	ch3 = k + getLDistanceTopDown(str1, str2, m-1, n-1, lDist)

	lDist[m-1][n-1] = min(ch1, ch2, ch3)

	return lDist[m-1][n-1]

#RECURSION
def getLDistance(str1, str2, m, n):
	if m == 0 or n == 0:
		return min(m, n)

	ch1 = 1 + getLDistance(str1, str2, m, n-1)
	ch2 = 1 + getLDistance(str1, str2, m-1, n)
	
	if str1[m-1] == str2[n-1]:
		k = 0
	else:
		k = 1

	ch3 = k + getLDistance(str1, str2, m-1, n-1)

	result = min(ch1, ch2, ch3)

	return result

str1 = "Tuesday"
str2 = "Thursday"

m = len(str1)
n = len(str2)

rows, cols = (m+1, n+1)
lDist = []
for i in range(rows):
	col = []
	for j in range(cols):
		col.append(-1)
	lDist.append(col)
		

minOperationDistance = getLDistance(str1, str2, m, n)
minOperationDistanceTopDown = getLDistanceTopDown(str1, str2, m, n, lDist)
minOperationDistanceBottomUp = getLDistanceBottomUp(str1, str2, m, n, lDist)

print(minOperationDistance)
print(minOperationDistanceTopDown)
print(minOperationDistanceBottomUp)