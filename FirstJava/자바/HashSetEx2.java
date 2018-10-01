package day4_7;

import java.util.*;

public class HashSetEx2 {

	public static void main(String[] args) {
		Object[] objArr = { "1", new Integer(1), "2", "2", "2", "3", "3", "4", "4", "4" }; // new
																							// Integer(1)은
																							// 명시적형태일뿐만아니라
																							// 정수를
																							// 나타내기때문에,"1"(문자열)과는
																							// 다른
																							// hash값을
																							// 갖는다.(둘은
																							// 다른것)
		Set set = new HashSet(); // Set이 인터페이스라서 set으로 받아도 되고 hashset으로 받아도 되고
									// 상관없음
		
		for(int i=0; i<objArr.length; i++)
		{
			set.add(objArr[i]); //HashSet에 objArr의 요소들을 저장한다.
		}
		
		//HashSet에 저장된 요소들을 출력한다.
		System.out.println(set);
	}
}
