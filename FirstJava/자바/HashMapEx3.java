package day5_7;
import java.util.*;
public class HashMapEx3 {

	public static void main(String[] args)
	{
		//일반화 안해줘서 노란경고 뜸
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));//키가 중복이니까 값만 갱신되어서 김자바,100된다.
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));
		
		Set set = map.entrySet();//entrySet()하면 쌍으로 저장되어있던게 하나의 묶음처럼 모여서 Set타입이 된다.
		Iterator it = set.iterator(); //위에서 만든걸 iterator()사용하면 접근할 수 있는 형태로 바뀐다.
		
		while(it.hasNext())//iterator랑은 짝꿍처럼 쓰이는 메소드 현재 커서의 다음에 데이터가 있는지 없는지 확인하는 메소드
		{
			Map.Entry e; //e는 객체가 아니라 변수임을 알아야한다. Map.Entry라는 인터페이스를 구현하고있는 객체의 주소값을 가지고 있는 변수.
			e = (Map.Entry)it.next();//casting
			System.out.println("이름 :"+e.getKey()+", 점수 :"+e.getValue());//Map.Entry에 들어있는 method
			//getKey() ->키값가져오고, getValue()->value값 가져오고
		}
		//이위에까지는 set이라는 변수 안에 entrySet()형태로  키값과 값으로 저장되어있었는데
		set = map.keySet(); //keySet()은 맵에 저장된 키값을 가져오기 때문에 이제 키값(이름)만 저장하게됨.
		System.out.println("참가자 명단 : "+set);//그래서 set을 사용해서 출력하면 이름만 딱딱 찍힘
		//Set의 toString 메소드는 []을 포함해서 출력하도록 구현되어있음
		
		//map의 value는 Collection형태, key는 Set형태니까 여기서는 Collection으로 받는것.
		Collection values = map.values();//값을 받아서 values에 저장(Collection)
		it = values.iterator();//iterator 이용해서 메모리에 저장된 형태에서 값에 접근이 가능한 형태가 되도록 만들어줌
		
		int total = 0;
		
		while(it.hasNext())
		{
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+(float)total/set.size()); //사칙연산거치면 실수형은 default가 double인데 그걸 float로 캐스팅해서 float로 나타내는 것.
		System.out.println("최고점수 : "+Collections.max(values)); //max는 Collection클래스에 포함되어있는 메소드
		System.out.println("최저점수 : "+Collections.min(values));// 마찬가지임
	}
}
