#BOTTOM-UP
def getMaxProfitBottomUp(weight, profit, n, capacity, values):
    for i in range(0, n+1):
        for j in range(0, capacity+1):
            if i == 0 and j == 0:
                values[i][j] = 0
            
            else:
                incl = 0
                excl = 0
                
                if weight[i-1] <= j:
                    incl = profit[i-1] + values[i-1][j - weight[i-1]]
                    
                excl = values[i-1][j]
                
                values[i][j] = max(incl, excl)
                
    return values[n][capacity]

#TOP-DOWN
def getMaxProfitTopDown(weight, profit, n, capacity, values):
	if(n == 0 or capacity == 0):
		values[n][capacity] = 0
		return 0

	if(values[n-1][capacity-1] != -1):
		return values[n-1][capacity-1]

	incl = 0
	excl = 0

	if(weight[n-1] <= capacity):
		incl = profit[n-1] + getMaxProfitTopDown(weight, profit, n-1, capacity - weight[n-1], values)

	excl = getMaxProfitTopDown(weight, profit, n-1, capacity, values)

	values[n-1][capacity-1] = max(incl, excl)

	return values[n-1][capacity-1]
	

weight = [7, 4, 5]
profit = [15, 8, 8]

capacity = 10

n = len(weight)

#array to store all the intermediate and final values.
#we are adding 1 for the size because we will store the values when there is no items present in the bag.
		
rows, cols = (n+1, capacity+1)
values = []
for i in range(rows):
	col = []
	for j in range(cols):
		col.append(-1)
	values.append(col)

maxProfitTopDown = getMaxProfitTopDown(weight, profit, n, capacity, values)
maxProfitBottomUp = getMaxProfitBottomUp(weight, profit, n, capacity, values) 

print(maxProfitTopDown)
print(maxProfitBottomUp)