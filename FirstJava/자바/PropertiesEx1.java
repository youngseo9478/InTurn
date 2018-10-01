package day5_7;
import java.util.*;
//HashMap이랑 비슷한데 구현이 더 간단하다.
public class PropertiesEx1 {

	public static void main(String[] args)
	{
		Properties prop = new Properties();
		
		//prop에 키와 값을 저장한다.(k,v)
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		//prop에 저장된 요소들을 Enumeration을 이용해서 출력한다.
		Enumeration e = prop.propertyNames(); //Iterator와 같은것.
		
		while(e.hasMoreElements())
		{
			String element = (String)e.nextElement();
			System.out.println(element+"="+prop.getProperty(element));
		}
		
		System.out.println();
		prop.setProperty("size", "20"); //size의 값을 20으로 변경한다.
		System.out.println("size = "+prop.getProperty("size"));
		System.out.println("capacity = "+prop.getProperty("capacity","20")); //capacity옆에 값은 디폴트값 . capacity의 값이 없으면 디폴트값을 출력
		System.out.println("loadfactor = "+prop.getProperty("loadfactor","0.75"));
		
		System.out.println(prop); //prop에 저장된 요소들을 출력한다.
		prop.list(System.out); //prop에 저장된 요소들을 화면(System.out)에 출력한다.
	}
}
