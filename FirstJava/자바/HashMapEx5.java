package day5_7;
/*******이정도하면 웬만한 맵은 사용할 수 있을 것임*******/
import java.util.*;
public class HashMapEx5 {

	public static void main(String[] args)
	{
		String[] data = {"A","K","A","k","D","K","A","K","K","K","k","Z","D"};
		
		//노란경고 뜨는이유는 generic을 안해주었기때문 원래 Class AA<T> { T[]~~}이런식으로 쓸수있는데 <>안을 안정해주면 default가 Object타입!
		HashMap map = new HashMap();
		
		for(int i=0; i<data.length;i++)
		{
			if(map.containsKey(data[i]))
			{
				Integer value = (Integer)map.get(data[i]); 
				map.put(data[i], new Integer(value.intValue()+1)); //맵의 value부분을 정수 객체로 받음
			}
			else
			{
				map.put(data[i], new Integer(1));
			}
		}
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+" : " +printBar('#',value)+" "+value);
		}
	}//main
	
	public static String printBar(char ch, int value)
	{
		char[] bar = new char[value];
		
		for(int i=0; i<bar.length;i++)
		{
			bar[i] = ch;
		}
		return new String(bar); 
	}
}
