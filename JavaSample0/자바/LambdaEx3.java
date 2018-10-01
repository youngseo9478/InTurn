package day11_7;
import java.util.function.*;
import java.util.*;


public class LambdaEx3 {

	public static void main(String[] args)
	{
		//supplier는 매개변수는 없고 리턴값은 있음 -> 리턴형을 정수형으로 지정한 것
		Supplier<Integer> s = ()->(int)(Math.random()*100)+1;
		
		//consumer는 리턴값은 없고 매개변수는 있음 -> 매개변수형을 정수형으로 지정한 것
		Consumer<Integer> c = i -> System.out.print(i+",");
		
		//Predicate는 받은 값을 조건을 통해 boolean타입의 리턴값을 던져주는 것
		Predicate<Integer> p = i -> i%2==0;  //2의 배수는 true값 가짐
		
		//Function은 매개변수와 리턴값을 가짐
		Function<Integer,Integer> f = i -> i/10*10; //정수형을 10으로 나누면 1의자리는 잘림 거기에 10을 곱하면 처음수에서 1의자리를 0으로 만든 수가 나옴
		
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		
		printEventNum(p, c, list);
		
		List<Integer> newList = doSomthing(f,list);
		System.out.println(newList);
		//System.out.println(list);
	}
	
	static <T> List<T> doSomthing(Function<T,T> f, List<T> list)
	{
		List<T> newList = new ArrayList<T>(list.size());
		for(T i:list)
		{
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void printEventNum(Predicate<T> p, Consumer<T> c, List<T> list)
	{
		System.out.print("[");
		for(T i:list)
		{
			if(p.test(i)) //predicate의 메소드로 조건에 맞는지 검사하는 메소드
				c.accept(i); //consumer에 있는 메소드로 i값을 매개변수로 가져오는 메소드
		}
		System.out.print("]");
		System.out.println();
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list)
	{
		for(int i=0; i<10; i++)
		{
			list.add(s.get()); //get()은 supplier에 포함되어있는 메소드
		}
	}
}
