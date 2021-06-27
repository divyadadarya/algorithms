def subSequence(word):

	if(len(word) == 0):
		return ""

	first = word[0:1]

	rest = subSequence(word[1:])

	result = ""

	for subseq in rest.split(","):
		result+= "," + first + subseq
		result+= "," + subseq

	return result[1:]

output = subSequence("abc")
print(output)
