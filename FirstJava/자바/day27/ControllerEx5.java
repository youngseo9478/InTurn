package day27;

import java.util.Scanner;	//Scanner를 사용하기위해서는 이 문장을 꼭 써줘야 한다.

	public class ControllerEx5 {	//console창에서 입력받는 방법 배우기

		public static void main(String[] args)
		{
			System.out.println("현재의 월을 입력하세요 > ");
			
			Scanner sc = new Scanner(System.in);		//Scanner는 입력받은 값은 저장하는 ...
			int month = sc.nextInt();	
			
			switch (month)
			{
			case 3:
			case 4:
			case 5:
				System.out.println("현재의 계절은 봄입니다.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("현재의 계절은 여름입니다.");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("현재의 계절은 가을입니다.");
				break;
			default:
				System.out.println("현재의 계절은 겨울입니다.");
			}
		}
}
