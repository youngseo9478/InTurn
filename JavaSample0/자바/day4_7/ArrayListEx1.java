package day4_7;
/*ArrayList(Collection<? extends E> c)
Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
위는 콜렉션 타입으로된 리스트만 받는다는 의미.
 * 
 * 배열리스트 역시 배열형태
 * 
 * 
 * ###List Interface###
 * 배열이랑은 다르게 가변적인 구조로도 사용이 가능하다.
 * Resizable-array implementation of the List interface.*/

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args)
	{
		ArrayList list1 = new ArrayList(10); 
		//이건 명시적으로 객체를 선언한 것 (정확히 말하면 정수는 아니지만 5,4,2,0,1,3의 값이 list1에 들어가는 것임)
		//명시적으로 객체를 생성했기때문에 집어넣은 순서대로 들어간다.
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); //subList(fromindex, toindex) 1,2,3에 해당하는 부분만 자른다
		print(list1, list2); //print()메소드에 객체를 넣으면 toString으로 보내져서 정의된 형태로 출력된다.
		
		System.out.println("list1.containsAll(list2) : "+list1.containsAll(list2)); //containsAll()의 리턴값은 true/false
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); //3번째 자리에다가 A를 넣어라 -> 원래 B,C순서로 들어가는데 A가껴들어서 하나씩 뒤로 밀림 ->개수가 많아지면 비효율적인 방법
		print(list1,list2);
		
		list2.set(3,"AA"); //위에서 index 3번에 원래 A였는데 set() 메소드 쓰면 추가로 AA가 들어가는게 아니라 기존에 있던거에 새로 덮어씌운다.=>##수정할때사용##
		print(list1,list2);
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2): "+list1.retainAll(list2));
		print(list1,list2);
		
		//list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i = list2.size()-1; i>=0;i--) //size()는 배열안의 원소 개수를 나타냄 index값을 표현하려면 -1해서 사용해야함.
		{/*###for문 index 증감선택시 주의사항!!###
		for문 안에서 인덱스 값의 초기화를 0으로해서 앞부터 비교하고 삭제하게되면 뒤에있던 값들이 앞으로
		당겨지게 되는데 이렇게 되면 삭제전에 두번째에 있던 값이 첫번째로 가져서 두번째 비교할때는 그 값은 건들이지 않고 그 다음 값(원래세번째)
		을 비교하게 된다. 
		##그래서 뭔가 비교하고 뺄때는 index를 뒤에서부터 참조해야 한다.##*/ 
		
			if(list1.contains(list2.get(i))) //list2에서 list1에 포함된 객체들을 삭제한다.
			{/*get(index) 이 index에 해당하는 값을 가져오는 것*/
				list2.remove(i);
			}
		}
		print(list1,list2);
	}//main끝
	
	static void print(ArrayList list1, ArrayList list2)
	{
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println();
	}
}//class끝
