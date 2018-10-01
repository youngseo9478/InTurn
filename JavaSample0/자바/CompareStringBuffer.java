package day29;

public class CompareStringBuffer {

	public static void main(String[] args) {

		long start, end;

		String str1 = new String("1~1000의 합 : "); //여기 매개변수 칸에 저렇게 쓰면 어떻게되는건지...?
		StringBuffer str2 = new StringBuffer("1~1000의 합 : ");

		start = System.currentTimeMillis();
		for (int i = 1; i <= 10; i++) {		//위아래의 이 숫자의 크기가 커질수록 차이가 점점 더 커진다.
			str1 += i;
			str1 += "+";		//어떻게 찍히는거지...?
		}
		end = System.currentTimeMillis();
		System.out.println("String : " + (end - start));
		System.out.println(str2);
		
		start = System.currentTimeMillis();
		for (int i = 1; i<= 1000; i++) {
			str2.append(i);
			str2.append("+");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer : " + (end - start));
	}
}
