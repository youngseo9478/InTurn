package day28;

class MethodEx{
	int var/*얘입장에서는 저 아래에 왼쪽 var가 지역변수*/;		//결과가 1000이 나올줄 알았는데 0이 나옴. 왜?
					//변수에도 우선순위가 있다. -> 지역변수>전역변수
					//결국 얘는 한번도 참조가 안된 것! 자바에서는 int 형태로 선언해놓고 값이 안들어가면 그냥 0으로 초기화(강제화)됨
	public void setInt(int var) //여기서부터 시작되었는데 아래에 오른쪽 var는 지역변수것을 먼저 사용한것. 다시 생각해보기...
	{
		this.var = var; //이렇게하면 1000이 출력됨 
		
		/*this의 개념
		 * */
		
		//var/*얘입장에서는 저 위에 var가 전역변수*/ = var; 
	}
	
	public int getInt()
	{
		return var;
	}
}

public class MethodEx2 {

	public static void main(String[] args)
	{
		MethodEx me2 = new MethodEx();
		me2.setInt(1000);
		System.out.println("var : "+me2.getInt());
	}
}
