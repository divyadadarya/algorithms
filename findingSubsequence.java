class Main{
	private static String getSubSequence(String word){

		if(word.isEmpty()){
			return "";
		}

		char first = word.charAt(0);

		String rest = getSubSequence(word.substring(1));
        
        String result = "";
		for(String subseq : rest.split(",", -1)){
			result+= "," + first + subseq;
			result+= "," + subseq;
		}

		return result.substring(1);
	}

	public static void main(String[] args){

		String word = "abc";

		String subsequence = getSubSequence(word);

		System.out.println(subsequence);

	}
}

//time complexity is O(2^N)
//space complexity is O(N)