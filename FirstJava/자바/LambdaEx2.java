package day11_7;
/*함수에게 매개변수를 던져주는 것이아니라 
 * 수행되어야할 함수를 던져줌으로써 
 * 멀티스레드 형태일 때 병행처리가 가능해짐*/
//ArrayList도 결국은 배열형태!!
import java.util.*;
public class LambdaEx2 {

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++)
		{
			list.add(i);
		}
		//list의 모든 요소를 출력 =>forEach는 for과 비슷한 것.
		list.forEach(i->System.out.print(i+","));
		System.out.println();
		
		//list에서 2또는 3의 배수를 제거
		list.removeIf(x->x%2==0||x%3==0);
		System.out.println(list);
		//list의 각 요소에 10을 곱한다.
		list.replaceAll(i->i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
				
		//mpa의 모든 요소를 {k,v}의 형식으로 출력한다.
		map.forEach((k,v)->System.out.print("{"+k+","+v+"},"));
		System.out.println();
	}
}
