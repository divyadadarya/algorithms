#BOTTOM-UP
def rodCutBottomUp(price, size):
	r = [0] * (size+1)

	maxRevenue = float('-inf')

	for i in range(1, len(r)):
		for j in range(1, i+1):
			maxRev = price[j-1] + r[i-j]
			maxRevenue = max(maxRevenue, maxRev)
		r[i] = maxRevenue

	return r[size]

#TOP-DOWN
def rodCutTopDown(price, n, dp):
    if(n == 0):
        return 0
        
    if dp[n-1] > 0:
        return dp[n-1]
    
    maxRevenue = float('-inf')
    
    for i in range(1, n+1):
        maxRev = price[i-1] + rodCut(price, n - i)
        maxRevenue = max(maxRevenue, maxRev)
        
    dp[n-1] = maxRevenue
    return dp[n-1]

#RECURSION
def rodCut(price, n):
	if n == 0:
		return 0

	maxRevenue = float('-inf')

	for i in range(1, n+1):
		maxRev = price[i-1] + rodCut(price, n - i)
		maxRevenue = max(maxRevenue, maxRev)

	return maxRevenue


price = [1, 5, 8, 9]
size = len(price)
dp = [0] * (size + 1)

maxRevenue = rodCut(price, size)
maxRevenueTopDown = rodCutTopDown(price, size, dp)
maxRevenueBottomUp = rodCutBottomUp(price, size)

print(maxRevenue)
print(maxRevenueTopDown)
print(maxRevenueBottomUp)