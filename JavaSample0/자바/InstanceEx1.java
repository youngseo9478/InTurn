package day28;

/*인스턴스화*/

class Card // 클래스는 new를 써야 메모리에 올라가지고 원래는 메모리 없음. 근데 예외로 변수 선언 앞에 static붙이면
			// 선언되어지는 순간 메모리에 올라와진다. 반면에 instance variable은 객체가 생성되어야 사용할 수 있는 변수
{
	static int width; // static ->공통으로 사용되어지는 느낌! ->객체는 여러개를 쓰되 공통으로 사용되는 어떤게
						// 필요할 때 이렇게 사용! 카드의 경우 width,height는 같으니까 그냥 static 해도 되는 것.
	static int height;
	String shape;
	int number;

	public void printCardInfo() {
		System.out.println("width : " + width);
		System.out.println("height : " + height);
		System.out.println("shape : " + shape);
		System.out.println("number : " + number);
	}
}

public class InstanceEx1 {

	public static void main(String[] args) {	//main 메소드는 static이므로 하나만 있는 것 ,public 이니까 아무나 공통으로 쓸 수 있는 것...
		Card c1 = new Card();
		c1.width = 80;		//사실 이건 두번 거치는 거고 원래는 Card.width와 같이 써줌 
		c1.height = 120;
		c1.shape = "spade";
		c1.number = 10;

		Card c2 = new Card();
		//c2.width = 90;	->static으로 ㅂㅏ꿧으니까 써줄 필요 없다.카드의 크기는 일정하니까!
		//c2.height = 140;
		c2.shape = "heart";
		c2.number = 3;

		c1.printCardInfo();
		System.out.println("====================================================");
		c2.printCardInfo();

	}
}
