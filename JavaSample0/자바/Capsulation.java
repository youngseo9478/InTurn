package day28;
/*capsulation
 * 캡슐의 특징
 * -은닉화 
 *
 *접근 지정자 :누가 사용할 수 있게 해주느냐를 결정
 *public -> 아무나 갖다써도 ok
 *private -> 내부에서만 사용할 수 있음
 *	->왜쓸까? 절대 외부에 보여지면 안되는 것들이 존재. 이런것들은 내부에서만 참조할 수 있게끔 해야한다. 이게 바로 '은닉'
 *	-->은닉되어있으면 어떻게 쓸까? '***간접적으로!***'
 *
 **/

class AccessEx
{
	public String name;
	private int weight;
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	/*public int getWeight()	??없애도 실행이되는데...왜지..	//직접 못가져오니까 이렇게 가져와야함 '간접적으로'넣어주는 형태!!***
	{
		return weight;
	}*/
	
	public void printInfo()
	{
		System.out.println("name : "+name);
		System.out.println("weight : "+weight);
	}
}

public class Capsulation {

	public static void main(String[] args)
	{
		AccessEx ae = new AccessEx();
		ae.name = "김가";
		ae.setWeight(90);
		//int getW=ae.getWeight();
		//ae.weight = 80;		//에러가 날 것임  The field AccessEx.weight is not visible
		ae.printInfo();
	}
}
