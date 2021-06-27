import java.lang.*; 
import java.io.*; 
import java.util.*; 
  
class ReverseString {
	public void rev(String s)
	{
		char[] try1 = s.toCharArray(); 
  
        for (int i = try1.length - 1; i >= 0; i--) 
            System.out.print(try1[i]); 
	}

    public static void main(String[] args) 
    { 
    	ReverseString a = new ReverseString();
        String input = "Hi my name is Divya!";
        a.rev(input);
    } 
} 