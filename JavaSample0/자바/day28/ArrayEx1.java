package day28;

/* Array
 * 배열은 같은 타입의 데이터 묶음이다.
 * <배열의조건>
 * -동일한타입
 * -연속된 데이터 집합->연속-->데이터접근에있어서 배열이 가장 빠르다.**
 * <배열선언>
 * int [] a = new int[4]; ->new는 클래스배울때 자세히, 자료형 뒤에 []해주면 배열할당하는 것  오른쪽에는 배열의 크기를 명시
 * char [] ch;
 * ch = new char[4] -->오른쪽값은 주소에 해당하는 것
 * 즉 ch가 주소값이라서 이걸 이용해서 주소를 지정해서 찾아갈 수 있다.
 * ch[0]~ch[3] :java는 인덱스가 0부터 시작!
 * 자바는 C와 다르게 눈에보이는 메모리 말고 더 많이 할당해놓음(=배열에대한정보저장이목적)sizeof이런거 쓸필요X : 크기(length=4)도 구해놓고 해시도 있고.
 * <배열쓸때주의할점>
 * ch[4] 참조하면 안됨...!ch[3]이 제일 마지막데이터!
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at day28.ArrayEx1.main(ArrayEx1.java:34) -->이런에러가 뜨게됨
 * */
public class ArrayEx1 {

	public static void main(String[] args)
	{
		char[] ch; //배열선언
		ch = new char[4]; //배열 생성
		
		//배열초기화
		ch[0]='J';
		ch[1]='a';
		ch[2]='v';
		ch[3]='a';
		
		//배열 내용 출력
		for(int i=0; i<ch.length; i++)	//length에 배열의 크기가 저장되어있다. ch크기는 4.인덱스가 0부터 시작되니까 i<4까지 for돌리면 0~3에 들어있는 4개의 데이터를 출력가능
		{
			System.out.println("ch["+i+"] : "+ch[i]);
		}
		
	}
}
