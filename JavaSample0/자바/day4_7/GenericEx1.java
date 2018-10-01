package day4_7;
/*colletion ->자료구조 내용
 * 자료구조란 ? 데이터를 저장하고, 저장된 데이터를 다시 사용하는 방법.
 * 자료구조의 저장에 대한 방법론이 '자료구조'
 * 그 상황에 맞는 효율적인 데이터 사용을 위해 필요한 내용.
 * 자바에서는 Object 타입을 삽입/삭제 한다. -> 클래스의 가장 상위 클래스가 오브젝트 => 모든하위클래스의 변수를 저장할 수 있다.=>어떠한 형태든지 가능하다.
 * 필터링 해주는 것 =>generic 
 * 
 * 특정 타입만 받고 싶은데 중간에 다른 타입이 들어와있을 경우 =>의도한 바와 다를 때.. =>해결하기위한 한가지 방법은 일반화하는 것 (generic)*/

import static java.lang.System.out;

class GenericC<T>
{
	T[] v; //T=>type 여기서 String 넣었으니까 String으로 바뀌는 것. =>String만 쓸 수 있다.
	
	public void set(T[] n)
	{
		v = n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			out.println(s);
		}
	}
}

public class GenericEx1 {

	public static void main(String[] args)
	{
		GenericC<String> gc = new GenericC<String>();
		Integer[] intArr = {1,2,3,4,5,6,7};
		String[] strArr = {"안녕하세요","반갑습니다","좋은하루되세요"};
		
		gc.set(strArr);
		gc.print();
		System.out.print("===================");
		System.out.println();
		/*에러남 => String으로 타입 명시를 해줬기떄문에 정수는 받을 수 없다.
		gc.get(intArr);
		gc.print();*/
		
		//타입명시를 안했기때문에 정수도 받고 문자열도 받을 수 있는 것.
		GenericC gc1 = new GenericC(); //type을 표시 안해주는 방법
		
		gc1.set(intArr);
		gc1.print();
		System.out.print("===================");
		System.out.println();
		//문자열인데 이것도 가능한 것 =>위에서 객체 생성할때 타입명시를 안했기 때문
		gc1.set(strArr);
		gc1.print();
		
	}
}
