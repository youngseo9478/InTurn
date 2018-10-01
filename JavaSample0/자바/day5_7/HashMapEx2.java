package day5_7;
import java.util.*;
public class HashMapEx2 {

	public static void main(String[] args)
	{
		//generic안해줘서 노란경고
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111"); //키값은 Set형태라 중복저장이 불가능
		map.put("asdf", "1234"); //같은 키값이 들어왔으므로 저장 안함. 그러나 뒤에 value는 저장(갱신)
		//위와같이 저장했기때문에 asdf의 비밀번호는 1234여야 맞는것.

		Scanner s = new Scanner(System.in); //화면으로부터 라인단위로 입력받는다.
		
		while(true)
		{
			System.out.println("id와 password를 입력해주세요. ");
			System.out.print("id : ");
			String id = s.nextLine().trim();
			
			System.out.print("password : ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) //저장되었지 않은 아이디를 입력했을 경우
			{
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue; //아래문장은 수행하지않고 다시 while문의 처음부분부터 실행함
			}
			else
			{//아이디는 존재하나
				if(!(map.get(id)).equals(password)) //map.get(id)라하면 id에 해당하는 값 즉 비밀번호를 뜻함
				{//비밀번호가 잘못된 경우
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}
				else
				{//비밀번호가 맞는 경우
					System.out.println("id와 password가 일치합니다.");
					break; //일치하는 아이디와 패스워드 입력받으면 while문 종료
				}
			}
		}//while 끝
	}//main 끝
}
