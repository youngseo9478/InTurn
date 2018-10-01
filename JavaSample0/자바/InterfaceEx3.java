package day30;
/*interface도 상속이 가능
 * 자바에서는 어떤 특징들을 없애는 등 색깔을 없애기 때문에 다중상속을 지원하지 않는데 
 * 인터페이스는 어떤 기능에 대한 헤더만 있기때문에 이걸로만 다른 애들의 색깔을 변화시키지는 않음 ->다중상속이 가능!*/

interface Inter1
{
	static final int VALUEA=100;
	
	public int getA();
}

interface Inter2
{
	static final int VALUEB=200;
	
	public int getB();
}

interface Inter3 extends Inter1, Inter2  //상속받아서 상수3개 메소드3개갖고있는거랑 같다.
{
	static final int VALUEC=400;
	
	public int getC();
}

class ImpleC implements Inter3//여기서 interface의 몸체가 구현이 되어진다. ->Inter1,2,3가 ImpleC의 조상처럼 행동함!
{
	public int getA()
	{
		return VALUEA;
	}
	public int getB()
	{
		return VALUEB;
	}
	public int getC()
	{
		return VALUEC;
	}
}

public class InterfaceEx3 {

	public static void main(String[] args)
	{
		ImpleC ic = new ImpleC();
		System.out.println("A : "+ ic.getA());
		System.out.println("B : "+ ic.getB());
		System.out.println("C : "+ ic.getC());
		//조상도아니고 심지어 Inter1은 인터페이스.  implements시켜서 연결해놓은것	
		//인터페이스가 몸체를 가지는 순간 클래스처럼 움직여질 수 있다.->객체화할 수 있다
		Inter1 it1 = ic;//Inter1이 조상이라고하면 2,3부분은 가려진채로 받는다. ->캐스팅으로 다 볼 수 있다.
		Inter2 it2 = ic;
		Inter3 it3 = ic;
		
		ImpleC ic2 = (ImpleC)it1;	//ImpleC 클래스 안에 Inter1,2,3가 모두 구현되어있기 때문에 캐스팅을 해주면 다 벗겨진 형태로 모든 걸 사용할 수 있음
		System.out.println("A:"+ic2.getA()+" B:"+ic2.getB()+" C:"+ic2.getC());
	}
}
