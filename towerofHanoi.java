class Main{

  public void tOH(int n, char from, char to, char aux){

		if(n==1){
			System.out.println("Moving the disk 1 from " + from + " to " + to + " rod.");
		}

		else{
			tOH(n-1, from, aux, to);
			System.out.println("Moving the disk " + n + " from " + from + " to " + to + " rod.");
			tOH(n-1, aux, to , from);
		}

	}

	public static void main(String[] args){
    Main p = new Main();
    p.tOH(4, 'x', 'y', 'z');

	}

	
}


//time complexity is O(2^N)
//space complexity is O(N)