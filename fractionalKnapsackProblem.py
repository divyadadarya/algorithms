class Item:
    def __init__(self, wt, val, index):
        self.wt = wt
        self.val = val
        self.index = index
        self.cost = val // wt
        
    def __lt__(self, other):
        return self.cost < other.cost


def getMaxValue(wt, val, capacity):
    
    totalValue = 0
    items = [0] * len(wt)
    
    for i in range(len(items)):
        items[i] = Item(wt[i], val[i], i)

    items.sort(reverse = True)

    for i in items:
        curWt = int(i.wt)
        curVal = int(i.val)
        
        if((capacity - curWt) >= 0):
            capacity-= curWt
            totalValue+= curVal
            
        else:
            fraction = capacity / curWt
            totalValue+= curVal * fraction
            capacity = int(capacity - (curWt * fraction))

    return totalValue

if __name__ == "__main__":
    wt = [10, 40, 20, 30]
    val = [60, 40, 100, 120]
    capacity = 50
    
    maxValue = getMaxValue(wt, val, capacity)

    print("The maximum profit possible = ", maxValue)
