package day27;

public class ControllerEx4 {	//switch case문 ->if문은 분기이지만 switch case문은 찾아가는 것
								//case에 상수를 넣고 쓰면 가독성이 좋기때문에 if랑은 또 다르다.
								//단점은 가독성은 좋지만 무거운 편이라 많이 사용하면 수행시간이 오래걸린다.
	public static void main(String[] args)
	{
		int score = 3;
		switch(score*100)	//괄호안에 정수, 캐릭터, 문자열 넣을 수 있다. ->문자열은 1.8버전부터만 가능
		{
		case 100:		//세미콜론 아니고 콜론!
			System.out.println("당신의 점수는 100이고, 상품은 자전거 입니다.");
			break;		//하나의 케이스를 수행하고서 switch문을 마칠 때는 break가 필요하다.
						//선택적으로 수행하려면 case마지막에는 break를 꼭 써줘야함.
		case 200:		//break를 쓰지 않으면 switch 문을 빠져나오지 않고 모든 케이스가 실행된다.
			System.out.println("당신의 점수는 200이고, 상품은 TV 입니다.");
			break;
		case 300:
			System.out.println("당신의 점수는 300이고, 상품은 노트북 입니다.");
			break;
		case 400:
			System.out.println("당신의 점수는 400이고, 상품은 자동차 입니다.");
			break;
		default:	//switch case 중 어느 곳에도 속하지 않는 경우 수행되는 구간
			System.out.println("죄송하지만 당신의 점수에 해당 상품이 없습니다.");
		}
	}
}
