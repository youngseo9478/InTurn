package day3_7;
import java.util.Arrays;
import static java.lang.System.out;
public class ArraysSorting {
	public static void main(String[] args)
	{
		int[] ar1 = {20,4,12,1,5};
		
		Arrays.sort(ar1);
		for(int n : ar1)
			out.println(n+",");
	}

}
