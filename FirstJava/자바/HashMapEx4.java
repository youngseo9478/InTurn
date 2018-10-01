package day5_7;
import java.util.*;
public class HashMapEx4 {

	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args)
	{
		addPhoneNo("친구","이자바","010-111-1111");
		addPhoneNo("친구","김자바","010-222-2222");
		addPhoneNo("친구","김자바","010-333-3333");
		addPhoneNo("회사","김대리","010-444-4444");
		addPhoneNo("회사","김대리","010-555-5555");
		addPhoneNo("회사","박대리","010-666-6666");
		addPhoneNo("회사","이과장","010-777-7777");
		addPhoneNo("세탁","010-888-8888"); //오버로딩해두었으므로 매개변수 두개짜리인 메소드로 

		printList();
	}//main
	
	//그룹을 추가하는 메소드
	static void addGroup(String groupName)
	{
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());//<k,v>에 v를 해쉬맵으로 취한 것.
	}
	
	//그룹에 전화번호를 추가하는 메소드
	static void addPhoneNo(String groupName, String name, String tel)
	{
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName); //get(groupName)한것은 <k,k,v>형태로생각해보면  <k,v>를 말하는 것. 즉 HashMap을 가져옴
		group.put(tel, name); //이름은 중복될 수 있으니 전화번호를 key로 저장한다.
	}
	//addPhoneNo 오버로딩 ->매개변수 개수를 2개짜리로 만든거
	static void addPhoneNo(String name, String tel)
	{
		addPhoneNo("기타",name,tel);
	}
	
	//전화번호부 전체를 출력하는 메소드
	static void printList()
	{
		Set set = phoneBook.entrySet();//처음형태의 entrySet()은 <k,|k,v>를 한덩어리로 보는 것 =>그룹명 기준으로 묶음이 됨.
		Iterator it = set.iterator();//접근할수있는형태로 모아주고
		
		while(it.hasNext()) //그룹명 출력하는 반복문
		{
			Map.Entry e = (Map.Entry)it.next(); //얘 역시 변수가 아니라 entry인터페이스가 구현되고있는 곳의 주소값을 가짐
			
			Set subSet = ((HashMap)e.getValue()).entrySet(); 
			//e는 그룹명기준으로 묶인 데이터였는데 여기서 getValue()라하면 <k,|k,v>중 뒤에<k,v>를 의미함, 즉 tel, name
			//이걸 다시 entrySet()으로 묶어주면 이제 전화번호를 기준으로 한덩어리로 묶는것. '010-111-1111,이자바'가 한덩어리
			Iterator subIt = subSet.iterator();
			
			//그룹명과 그룹에 속한 정보의 개수를 출력
			System.out.println("*"+e.getKey()+"["+subSet.size()+"]");
			//e.getKey()는 그룹명을 나타냄 -> 위에서 e.getValue()는 tel,name덩어리를 나타냄
			//subSet은 해당하는 e.getKey안에 속한 e.getValue() 즉, '번호,이름'덩어리의 개수( e.getKey마다 갖고있는 개수가 다름을 알기)
			while(subIt.hasNext())//그룹안의 정보(연락처 개수)를 출력하는 반복문
			{
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();//subE.getKey()는 tel을 읨(문자열)
				String name = (String)subE.getValue(); //subE.getValue()는 name을 의미(문자열)
				System.out.println(name+" "+telNo); //이름과 번호 순으로 출력됨
			}
		}
	}//printList()
}//class
