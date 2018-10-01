package day11_7;
/*객체를 주고받기 위해서 직렬화를 시키는 것 =>Serializable 이용
 * 클래스만 구현 해둔 것으로 SerialEx에서 이 클래스를 사용하게 됨...*/
public class UserInfo implements java.io.Serializable {

	String name;
	String password;
	int age;
	
	public UserInfo()
	{
		this("Unknown","1111",0);
	}
	
	public UserInfo(String name, String password, int age)
	{
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString()
	{
		return "("+name+","+password+","+age+")";
	}
}
