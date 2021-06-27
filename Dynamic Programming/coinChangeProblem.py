#BOTTOM-UP
def minCoinsBottomUp(coins, l, total):
	arr = [0] * (total+1)

	for i in range(1, len(arr)):
		arr[i] = float('inf') - 1

	for i in range(0, l):
		for j in range(1, len(arr)):
			if coins[i] <= j:
				if(1 + arr[j - coins[i]] < arr[j]):
					arr[j] = 1 + arr[j - coins[i]]

	return arr[total]

#TOP-DOWN
def minCoinsTopDown(coins, l, total, Dict):
	result = float('inf')

	if total == 0:
		return 0;

	if total in Dict:
		return Dict.get(total);

	for i in range(0, l):
		if(coins[i] <= total):
			subResult = minCoinsTopDown(coins, l, total - coins[i], Dict)

			if (subResult != float('inf')) and ((subResult + 1) < result):
				result = subResult + 1

	Dict[total] = result
	return result

#RECURSIVE
def minCoins(coins, l, total):
	result = float('inf')

	if total == 0:
		return 0

	for i in range(0, l):
		if(coins[i] <= total):
			subResult = minCoins(coins, l, total - coins[i])

			if((subResult != float('inf')) and ((subResult + 1) < result)):
				result = subResult + 1
				

	return result

coins = [1, 3, 5, 2]
l = len(coins)
total = 7
Dict = {}

minNumber = minCoins(coins, l, total)
minNumberCoins = minCoinsTopDown(coins, l, total, Dict)
minCoins = minCoinsBottomUp(coins, l, total)

print(minNumber)
print(minNumberCoins)
print(minCoins)