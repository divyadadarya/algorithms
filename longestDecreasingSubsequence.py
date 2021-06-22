#BOTTOM-UP
def getLdsBottomUp(nums):
	l = len(nums)
	if l == 0:
		return 0

	maxLds = [1] * (l+1)
	maxSoFar = 1

	for i in range(1, l):
		for j in range(0, i):
			if nums[i] < nums[j]:
				maxLds[i] = max(maxLds[i], maxLds[j] + 1)
		maxSoFar = max(maxLds[i], maxSoFar)

	return maxSoFar

#TOP-DOWN
def getLdsTopDown(nums, prevIndex, curr, dp):
	if curr == len(nums):
		return 0

	if dp[prevIndex+1][curr] > 0:
		return dp[prevIndex+1][curr]

	incl = 0
	if prevIndex < 0 or nums[curr] < nums[prevIndex]:
		incl = 1 + getLdsTopDown(nums, curr, curr+1, dp)

	excl = getLdsTopDown(nums, prevIndex, curr+1, dp)

	dp[prevIndex+1][curr] = max(incl, excl)

	return dp[prevIndex+1][curr]

#RECURSION
def getLds(nums, i, prev):
	if i == len(nums):
		return 0

	incl = 0

	if nums[i] < prev:
		incl = 1 + getLds(nums, i+1, nums[i])

	excl = getLds(nums, i+1, prev)

	return max(excl, incl)

nums = [20, 8, 12, 16, 10, 9, 18, 7]

rows, cols = (len(nums) + 1, len(nums))
dp = []
for i in range(rows):
	col = []
	for j in range(cols):
		col.append(-1)
	dp.append(col)

maxi = getLds(nums, 0, float('inf'))
maxTopDown = getLdsTopDown(nums, -1, 0, dp)
maxBottomUp = getLdsBottomUp(nums)

print(maxi)
print(maxTopDown)
print(maxBottomUp)