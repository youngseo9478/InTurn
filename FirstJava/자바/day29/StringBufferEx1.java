package day29;
/*대단위 스트링을 쓸때에는 스트링버퍼가 더 빠르다! 스트링은 굉장히 잘만들어져있기때문에 그만큼 프로그램이 무겁다.그래서 수행시간이 긴편이기때문에 스트링의 크기가 크다면 스트링버퍼를 사용!!*/
public class StringBufferEx1 {

	
	public static void main(String[] args)
	{
		StringBuffer sb1= new StringBuffer("Sun-Ae");
		StringBuffer sb2= sb1.append("&Kyung-ju"); //sb2는sb1의 주소값을 대입받게됨
		
		String msg = null;
		
		if(sb1==sb2)
			msg = "sb1과 sb2는 같다";
		else
			msg = "sb1과 sb2는 다르다";
		
		System.out.println(msg);
		msg = sb1.toString();
		System.out.println("sb1: "+msg);
		msg = sb2.toString();
		System.out.println("sb2: "+msg);
	}
}
