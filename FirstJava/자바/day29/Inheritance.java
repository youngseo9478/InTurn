package day29;
/*상속
 * 객체지향의 핵심
 * 상속을 시켜주는 애와 상속을 받는 애가 있다.
 * 물려주는애를 -> 조상클래스 (=부모클래스)
 * 상속을받는애들 -> 하위클래스(=자식클래스)
 * 
 * 상속을 할 때 사용하는 예약어가 있다!
 * 	-> 자식클래스 extends 부모클래스
 * 기존에 만들어 놓은 것을 그대로 쓰면서 해당하는 기능만 추가할 수 있게됨
 *  ->재코딩을 할 필요가 없다  **생산성높아지고 유지보수 용이해짐
 * 
 * 객체를 생성할때 그 안에 부모영역과 자식영역이 분리되어 있고 겉에서 보기에 하나처럼 행동해서 
 * 결국 하나의 객체로 수행된다. --> Mp3Phone 클래스를 바탕을 만든 객체에서 call, sendSMS를 나타낼 수 있는것 마치 원래 Mp3Phone클래스에 있는것처럼!!
 * 
 * 자바의 경우는 단일상속만 가능
 * C++의 경우 다중상속도 가능
 * 
 * 어떤게 더 좋을까? 단일상속, 이제 실무에서는 다중상속 절대 안씀
 * 
 * 다중상속의 문제점 너무 많아서 사라짐
 * -많은 기능을 가져다 쓸 수 있다는게 좋지만 ...(상속을 하는 이유는 코드의 재사용을 위함)->상속받은 속성을 그대로 유지해야하는데 다중상속하면 그 속성이 무너져버림
 * -누구를 참조해야하는지 어떤식으로 참조해야하는지 헷갈리게됨 (이제아예지원안해줌)
 * 
 * */

class CellPhone //전화기의 기능을 가진 클래스
{
	String maker;
	String number;
	
	public void call(String number)
	{
		System.out.println(number+"에게 전화를 합니다.");
	}
	
	public void sendSMS(String num, String message)
	{
		System.out.println(num+"에게 '"+message+"' 메세지를 보냅니다.");
	}
	
}

class Mp3Phone extends CellPhone  //전화기의 기능을 상속받은 엠피쓰리기능이 추가된 기능을 가진 클래스
{
	String musicName;
	
	public void playMp3(){
		System.out.println(musicName+"을 재생합니다.");
	}
}

class SmartPhone extends Mp3Phone //전화,문자,음악재생 기능을 모두 상속받은 스마트폰 클래스
{
	int pixel;
	
	public void takePictur()
	{
		System.out.println(pixel+"화소의 사진을 찍습니다.");
	}
}
public class Inheritance {

	public static void main(String[] args)
	{
		Mp3Phone m3 = new Mp3Phone();
		//Mp3Phone에는 정의되지 않은 메소드인데 여기서 사용이 가능
		m3.call("010-7878-8989");
		//역시 정의되지 않은 메소드인데 사용이 가능 -->상속이 이루어졌기때문에 Mp3Phone class는 엠피쓰리에 관해서만 정의할 뿐 나머지 기능은 CellPhone으로부터 받았다.
		m3.sendSMS("010-4545-5656", "hello");
		m3.musicName = "it has to be you";
		m3.playMp3();
		
		System.out.println("=========================================");
		
		SmartPhone sp = new SmartPhone();
		sp.pixel = 10000; //픽셀값을 정해주는 것.
		sp.call("010-5580-8707"); // 전화도 하고
		sp.sendSMS("010-8485-1407", "I love you"); //문자도 받고
		sp.musicName = "my way"; //노래 제목을 정해줌
		sp.playMp3(); //그 노래를 재생함
		sp.takePictur(); //사진도 찍음
	}

}
