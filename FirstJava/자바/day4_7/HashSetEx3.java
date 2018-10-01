package day4_7;
import java.util.*;
public class HashSetEx3 {

	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		//문자열 "abc"는 같은 해쉬값가져서 한번만 들어간다(중복저장하지 않는 set의 특성)
		set.add("abc");
		set.add("abc");
		//명시적인 형태로 객체를 생성하면 주소값이 서로 다르다. 
		//주소값이 다르면 hash도 다르게 나온다.
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
		//객체를 print메소드에 던져주면 toString에 들어가서 정의된 형태에 맞게 출력된다.
	}
}

class Person
{
	String name;
	int age;
	
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//toString 오버라이딩(재정의)->출력형태변형
	public String toString()
	{
		return name +" : "+age;
	}
}
