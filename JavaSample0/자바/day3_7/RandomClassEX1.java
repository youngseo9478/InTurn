package day3_7;
/*random()보다 더 쉽게 난수 발생시키는 방법
 * 
 * seed ->난수를 어떤 기준에 의해 ...*/

import java.util.Random;
import static java.lang.System.out;

public class RandomClassEX1 {

	public static void main(String[] args)
	{
		String[] lesson = {"Java Beg","JSP","XML&Java","EJB"};
		Random r1 = new Random();
		
		int index = r1.nextInt(4);	//nextInt(n)->0~n-1까지의 숫자 중에 랜덤 값
		out.println("선택과목 "+lesson[index]);
	}
}
