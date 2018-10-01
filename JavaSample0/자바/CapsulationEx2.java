package day28;

//private으로 선언하고 set, get함수를 이용해서 간접적으로 사용하는 것이 좋다. 정보가 무분별하게 옮겨지거나 정의되는걸 막기 위해!
class Time
{
	private int hour;
	//public int hour;  ->이러게하면 24시이상인 숫자도 막 들어가 짐
	public int min;
	public int second;
	
	/*public void setHour(int h)
	{
		hour = h;
	}*/  //private으로 변수 타입 바꿔주고 이렇게 해도 문제가 해결이 안됨
	public void setHour(int h)
	{
		if(h<24)
		{
			hour = h;
		}
		else
		{
			System.out.println("시간을 잘못 입력하였습니다. 다시 입력해주세요");
		}
		
	}
	
	public void printTime()
	{
		System.out.println(hour+"시"+min+"분"+second+"초");
	}
	
}

public class CapsulationEx2 {

	public static void main(String[] args)
	{
		Time t = new Time();
		
		t.setHour(50);
		t.min = 50;
		t.second =45;
		t.printTime();
	}
}
