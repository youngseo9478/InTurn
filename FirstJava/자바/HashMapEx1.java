package day5_7;
/****Map****/
import java.util.*;
import static java.lang.System.out;
public class HashMapEx1 {

	public static void main(String[] args)
	{
		String[] msg = {"Berlin","Dortmund","Frankfurt","Gelsenkirchen","Hamburg"};
		
		HashMap<Integer,String> map = new HashMap<Integer,String>(); //해쉬맵 생성
		
		//키값의 시작도 0부터 주었음, length = 5
		for(int i=0; i<msg.length;i++)
			map.put(i, msg[i]);//키값과 데이터값을 쌍으로 맵에 저장
		
		//키는 셋타입, keySet()은 맵에 저장된 모든 키값을 가져오는 것.
		Set<Integer> keys = map.keySet();
		//out.println(map.keySet());
		for(Integer n : keys)
		{//키값을 n에 대입
			out.println(n+"."+map.get(n)); //해당 키값의 정보를 맵에서 읽어오기
		}
		
	}
}
