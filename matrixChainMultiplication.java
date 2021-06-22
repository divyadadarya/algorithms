class Main{

	private static int mcm(int[] seq, int i, int j){
		if(i == j){
			return 0;
		}

		int minOps = Integer.MAX_VALUE;

		for(int k = i; k < j; k++){
			int ops = mcm(seq, i, k) + mcm(seq, k+1, j) + seq[i-1] * seq[k] * seq[j];
			minOps = Math.min(ops, minOps);
		}

		return minOps;
	}

	public static void main(String[] args){

		int[] seq = {4, 3, 2, 1, 5}; //A0 = 4*3, A1 = 3*2, A2 = 2*1, A3 = 1*5 (Ai are matrices)
		int n = seq.length;

		int minOperations = mcm(seq, 1, n-1); //array, starting and ending indices.

		System.out.println(minOperations);
	}
}