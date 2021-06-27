import java.io.*;
import java.util.*;

class Main{
	public String firstRecurringCharachterHM(String arr[]){
	    HashMap<String, Integer> table = new HashMap<String, Integer>();
	    for(int i=0;i<arr.length;i++){
	      if(!table.containsKey(arr[i]))
	      	table.put(arr[i], 1);
	      else return arr[i];
	    }
	    return "Not Found";
	}

	public static void main(String[] args){
		Main a = new Main();
		String arr[]={"nemo", "a", "b", "d", "z", "x", "y", "w", "a"};
		String element = a.firstRecurringCharachterHM(arr);
		System.out.println(element);
	}
}