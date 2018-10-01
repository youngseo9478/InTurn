package day29;

/*String의 함수들!!*/

public class UsableMethodEx1 {

	public static void main(String[] args)
	{
		String s1 = "have a good day";	//문자열을 s1에 대입
		
		//indexOf는 소괄호 안에 있는 문자의 위치를 나타낸다.
		int index = s1.indexOf('a');
		System.out.println("맨 처음 문자 a의 위치 : "+index);
		
		//indexOf는 오버로드되어있어서 문자열의 위치를 알아내는 것도 가능하다.
		index = s1.indexOf("ood");
		System.out.println("문자 ood의 위치 :" +index);
		
		//lastIndexOf는 소괄호 안의 문자가 존재하는 마지막 위치를 나타낸다.
		index = s1.lastIndexOf('a');
		System.out.println("마지막 문자 a의 위치 : "+index);
		
		//charAt은 소괄호안의 인덱스(위치)에 해당하는 문자를 나타낸다.
		char c = s1.charAt(index);
		System.out.println("추출한 문자 :"+c);
		
		//substring은 소괄호 안의 위치에서부터 나머지 부분을 잘라내는 것인데
		//여기서는 g의 위치를 인덱스변수에 대입하고 그 값(g의 위치값)을 이용해서 g부터 나머지부분을 잘라낸다.
		index = s1.indexOf('g');
		String str = s1.substring(index);
		System.out.println("g로부터 끝가지 잘라내기 : " +str);
		
		//매개변수를 두개주어서 잘라낼 첫번째위치와 어디까지 잘라낼것인지도 지정해줄 수 있다.
		str = s1.substring(index, index+3);
		System.out.println("g로부터 3자리까지 잘라내기 :"+str);
		
		//length는 문자열의 길이(크기)를 구하는 함수이다.
		int length = s1.length();
		System.out.println("s1의 길이 : "+length);
		
		//toUpperCase함수는 사용한 알파벳을 모두 대문자로 나타내준다.
		String str2 = s1.toUpperCase();
		System.out.println("uppercase 사용 : "+str2);
		
		//toLowerCase는 알파벳을 모두 소문자로 나타내준다.
		str2 = s1.toLowerCase();
		System.out.println("lowercase 사용 ;"+str2);
		
		//split은 문자열을 소괄호안에 있는 문자를 기준으로 잘라주는 것이다. 여기서는 공백을 기준으로 잘라냄
		//이값은 스트링 타입의 배열에 저장된다.-->사실이거보다 그냥 StringTokenizer class를 더 많이 사용한다.
		String[] arr = s1.split(" ");
		for(int i=0; i<arr.length; i++)	//쪼개진 개수가 length값이 됨
		{
			System.out.println("arr["+i+"] :"+arr[i]);
		}
		
		//분리된 arr을 붙이는 함수
		String joinStr = String.join("-", arr);
		System.out.println("Join method : "+joinStr);
		
		//String format을 만들어 사용 하는 것.
		String str3 = String.format("%d 더하기 %d 는 %d 입니다.", 3,5,3+5);
		System.out.println("string format : "+str3);
	}
}
