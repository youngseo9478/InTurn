package day3_7;
import java.util.Arrays;
import static java.lang.System.out;
public class ArraysEx1 {
	public static void main(String[] args)
	{
		String[] ar = {"fill()","in","the","Arrays"};
		String[] ar2 = {"fill()","in","","Arrays"};
		if(!Arrays.equals(ar, ar2))
		{
			out.println("두 배열이 다릅니다.");
			out.println("\n-------------------------------");
		}
		Arrays.fill(ar,"SunAe"); //어레이의 요소들을 모두 SunAe로 채운다.
		for(String n: ar)
			out.print(n+",");
		
		out.println("\n-------------------------------");
		Arrays.fill(ar,1,3,"♥"); //1,2는 하트로 바꾸라는 것
		for(String n : ar)
			out.print(n+",");
	}

}
