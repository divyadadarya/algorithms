import java.util.*;

class Main{

	private static List<int []> schedule(int[][] intervals){
		List<int []> optimalIntervalSet = new ArrayList<>();

		Arrays.sort(intervals, new Comparator<int[]> (){

			@Override
			public int compare(int[] o1, int[] o2){
				return o1[1] - o2[1]; //sort in ascending order
			}
		});

		int lastFinishTime = Integer.MIN_VALUE;

		for(int[] interval : intervals){
			int start = interval[0];
			if(start > lastFinishTime){
				int end = interval[1];

				optimalIntervalSet.add(interval);

				lastFinishTime = end;
			}
		}

		return optimalIntervalSet;
	}

	public static void main(String[] args){
		int[][] intervals = {{0, 3}, {0, 15}, {5, 10}, {7, 12}, {11, 16}, {12, 14}, {16, 20}};

		List<int []> optimalSchedule = schedule(intervals);

		for(int[] is : optimalSchedule){
			for (int i = 0; i < is.length; i++){
				System.out.print(is[i] + " ");
			}
			System.out.println();
		}
	}
}


//time complexity - O(nlogn) + O(n) => O(nlogn)
//space complexity - O(n)