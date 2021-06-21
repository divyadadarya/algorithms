// To calculate the minimum number of operations it takes to transform one string to another string

/* 

OPERATIONS THAT CAN BE PERFORMED 
    - Insertion
    - Deletion
    - Substitution

*/

class Main{

	private static int getLDistance(String str1, String str2, int m, int n){
		int result;

		if(m == 0 || n ==0){
			result = Math.max(m, n);
			return result;
		}

		int ch1 = 1 + getLDistance(str1, str2, m, n-1); //Insertion
		int ch2 = 1 + getLDistance(str1, str2, m-1, n); //Deletion

		//if last index characters are equal of both strings, k = 0, otherwise k = 1
		int k = str1.charAt(m-1) == str2.charAt(n-1) ? 0 : 1;

		int ch3 = k + getLDistance(str1, str2, m-1, n-1);

		result = Math.min(ch1, Math.min(ch2, ch3));
		return result;
	}

	public static void main(String[] args){

		String str1 = "Tuesday";
		String str2 = "Thursday";

		int m = str1.length();
		int n = str2.length();

		int minOperationDistance = getLDistance(str1, str2, m, n);
		System.out.println(minOperationDistance);
	}
}