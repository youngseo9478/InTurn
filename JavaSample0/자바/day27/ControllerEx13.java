package day27;
import java.util.Scanner;
public class ControllerEx13 {

	public static void main(String[] args)
	{
		int menu = 0;
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.println("원하는 메뉴(1~3)를 선택하세요. (종료 :0) >");
			menu = sc.nextInt();
			
			if(menu==0)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if (!(1<=menu && menu<=3))
			{
				System.out.println("메뉴를 잘못 선택하였습니다. 다시 입력해주세요");
				System.out.println();
				continue;	//컨티뉴하면 아래는 수행안되고 다시 와일문의 조건으로 가서 시작하기때문에 밑에 써진 문장이 출력되지 않는다.
			}
			System.out.println("선택하신 메뉴는 "+menu+"번 입니다.");
			System.out.println();
		}
	}
}
