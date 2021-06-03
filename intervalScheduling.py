def compare(x, y):
	return x[1] - y[1]

def schedule(intervals):
    optimalIntervalSet = []

    from functools import cmp_to_key
    intervals = sorted(intervals, key = cmp_to_key(compare))

    lastFinishTime = -2^31
    
    for i in intervals:
        start = i[0]
        if start > lastFinishTime:
            end = i[1]
            optimalIntervalSet.append(i)
            lastFinishTime = end
            
    return optimalIntervalSet

intervals = [[0, 3], [0, 15], [5, 10], [7, 12], [11, 16], [12, 14], [16, 20]]
optimalSchedule = schedule(intervals)

for i in range(len(optimalSchedule)):
	print(optimalSchedule[i])