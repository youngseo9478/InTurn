package day11_7;
import java.io.*;
/**/
class SuperUserInfo //직렬화가 안된애!
{
	String name;
	String password;
	
	SuperUserInfo()
	{
		this("Unknown","1111");
	}
	
	SuperUserInfo(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
}//class SuperUserInfo


//SuperUserInfo를 상속받아서! 직렬화를 여기서 진행하는 것!
public class UserInfo2 extends SuperUserInfo implements java.io.Serializable{

	int age;
	
	public UserInfo2()
	{
		this("Unknown","1111",0);
	}
	
	public UserInfo2(String name, String password, int age)
	{
		super(name, password);
		this.age = age;
	}
	
	public String toString()
	{
		return "("+name+","+password+","+age+")";
	}
	
	//Super는 직렬화가 안되어있음!! 강제로 직렬화 시켜주기 위해서 =>직렬화안되면 직렬화객체에 들어가지질 않음 
	private void writeObject(ObjectOutputStream out) throws IOException 
	{
		out.writeUTF(name); //output의 메소드
		out.writeUTF(password);
		out.defaultWriteObject();
		
	}
	
	//위와 마찬가지로 강제로 직렬화시켜주기 위해
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		name = in.readUTF(); //input의 메소드
		password = in.readUTF();
		in.defaultReadObject();
	}
}//class UserInfo2
