package day4_7;
import java.util.*;
import static java.lang.System.out;
public class StackEx1 {

	public static void main(String[] args)
	{
		String[] groupA = {"우즈베키스탄","쿠웨이트","사우디","대한민국"};
		
		Stack<String> stack = new Stack<String>();//문자열이 들어갈 수 있는 Stack 객체를 만듬
		for(String n : groupA)
		{
			stack.push(n); //groupA에 들어있는 문자열들을 하나하나 스택에 쌓음
		}
		while(!stack.isEmpty()) //isEmpty()는 비었는지 확인하는 거 비었으면 true, 차있으면 false니까 while의 조건문에 ! 붙여줌
		{
			out.println(stack.pop()); //스택에서 데이터 빼내고 그 데이터는 스택에서 삭제 => 넣은순서와 반대로 나옴 ##LIFO##
		}
	}
}
