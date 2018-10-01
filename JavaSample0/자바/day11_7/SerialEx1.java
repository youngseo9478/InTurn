package day11_7;
/************직렬화*****************
 * Serialize(직렬화) : 객체 단위로 스트림을 통해서 전송하는 것
 *객체 단위로 파일에 저장할 수 있고 네트워크를 통해서 전송할 수 있도록 해줍니다.
 *자바에서는 Serializble 인터페이스가 이 역할을 수행합니다.


<<<직렬화가 가능한 객체의 조건>>>
(1) 기본형 타입(boolean, char, byte, short, int, long, float, double)은 직렬화가 가능
(2) Serializable 인터페이스를 구현한 객체여야 한다. (Vector 클래스는 Serializable 인터페이스구현)
(3) 해당 객체의 멤버들 중에 Serializable 인터페이스가 구현되지 않은게 존재하면 안된다.
(4) transient 가 사용된 멤버는 전송되지 않는다. (보안 변수 : null 전송)
 * 
 * ObjectOutputStream는 Serializble인터페이스를 implements해주어준 것만 사용이가능하다.
 * //ArrayList가 serializable을 implements하고 있기때문에 사용가능한 것*/
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//직렬화해서 오브젝트스트림에 쓰는 것!!
//직렬화 시키고 싶은 클래스(해당데이터)에 시리얼라이져블을 구현해 놓아야함
/**/
public class SerialEx1 {

	public static void main(String[] args)
	{
		try{
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			//따로만들어두었던 UserInfo 클래스로 객체를 만든 것
			UserInfo u1 = new UserInfo("JavaMan","1234",30);
			UserInfo u2 = new UserInfo("JavaWoman","4321",24);
			
			//UserInfo 형으로 구성된 list를 만들고 UserInfo의 객체들을 list에 추가해줌
			ArrayList<UserInfo> list = new ArrayList<>(); 
			list.add(u1);
			list.add(u2);
			
			//writeObject메소드가 객체를 직렬화한다.=>Specified by: writeObject(...) in ObjectOutput
			out.writeObject(u1); //u1 객체를 오브젝트스트림에 쓴다. 
			out.writeObject(u2);
			out.writeObject(list); //u1,u2를 추가시킨 list도 직렬화해주면 역직렬화해서 읽을때 배열리스트 형태로 출력되는것을 보기위함!
			out.close();
			System.out.println("직렬화가 잘 끝났습니다.");
		}catch(IOException e){e.printStackTrace();}
	}//main
}//class
