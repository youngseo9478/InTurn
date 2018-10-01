package day4_7;
/*콜렉션 프레임워크
 * 
 * 자바에서 자료구조는 크게 두 가지 타입 
 * 1.collection<E>  *E : element->object  =>(어떤타입이든)하나의 데이터를 저장
 * 	-List : 배열형태로 미리 할당하고 거기에 객체를 저장
 * 	-queue : 링크형태로 해서 저장
 * 	-set : 순서없이
 * 
 * 2.map<k,v> *k : key, v : value =>두개의 데이터를 동시에 저장
 * 
 * */
import java.util.*;
import static java.lang.System.out;

public class HashSetEx1 {

	public static void main(String[] args)
	{
		String[] str = {"Java","Beans","Java","XML"};
		
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		
		for(String n : str)
		{
			if(!hs1.add(n)) //조건식 안에 !가 있으니까 true가 들어오면 if문 수행안하고 false가 들어오면 수행하는 것.
			{
				hs2.add(n);
			}
		}
		out.println("hs1 : "+hs1); //나올때는 순서대로 안나오는데 가끔 순서대로 나오는 경우가 있을뿐=> 헷갈리지말기!
		hs1.removeAll(hs2); //remove(hs2)는 hs1이 hs2라는 객체를 갖고있으면 지우라는 것. (hs2안에있는 내용을 말하는게 아니라 hs2 이름자체)
		out.println("hs1 : "+hs1);
		out.println("hs2 : "+hs2);
		
	}
}
