def towerofHanoi(n, fr, to, aux):

	if n==1:
		print("Moving the disk 1 from " , fr , " to " , to , " rod.")

	else:
		towerofHanoi(n-1, fr, aux, to)
		print("Moving the disk ", n , " from " , fr , " to " , to , " rod.")
		towerofHanoi(n-1, aux, to, fr)

towerofHanoi(4, 'x', 'y', 'z')