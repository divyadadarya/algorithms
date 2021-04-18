import java.util.*;
class Main{

	static class Item{

		Double cost;
		double wt, val, index;

		public Item(int wt, int val, int index){

			this.wt = wt;
			this.val = val;
			this.index = index;

			this.cost = Double.valueOf(val/wt);
		}
	}

	private static double getMaxValue(int[] wt, int[] val, int capacity){

		Item[] items = new Item[wt.length];
		int i;

		for(i = 0; i < items.length; i++){
			items[i] = new Item(wt[i], val[i], i);
		}

		Arrays.sort(items, new Comparator<Item>(){

			@Override
			public int compare(Item o1, Item o2){
				return o2.cost.compareTo(o1.cost);
			}
		} );

		double totalValue = 0d;

		for(Item item : items){

			int curWt = (int)item.wt;
            int curVal = (int)item.val;

            if(capacity - curWt >= 0){

            	capacity = capacity - curWt;
            	totalValue = totalValue + curVal;
            }

            else{

            	double fraction = (double)capacity/(double)curWt;
            	totalValue+= curVal * fraction;
            	break;
            }
		}

		return totalValue;
	}

	public static void main(String[] args){

		int[] wt = {10, 40, 20, 30};
		int[] val = {60, 40, 100, 120};
		int capacity = 50;

		double maxValue = getMaxValue(wt, val, capacity);

		System.out.println("The maximum profit possible = " + maxValue);

	}
}

//time complexity - O(nlogn)
//space complexity - O(1)