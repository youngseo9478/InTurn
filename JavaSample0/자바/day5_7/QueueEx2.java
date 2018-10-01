package day5_7;
/*****ArrayList VS LinkeList(삽입삭제시간비교)*****/
/*삽입삭제가 많을경우에는 링크드 리스트가 빠르다.
 *순차적인 데이터의 경우 어레이리스트가 유리하다.*/
/*****ArrayList VS LinkeList(접근시간비교)*****/
/*배열은 순차적인 데이터를 가져오는 것이기때문에 이경우에는 ArrayList가 더 빠름
 * 접근시간의 경우는 링크드 리스트가 더 오래 걸린다.*/
import java.util.*;
public class QueueEx2 {

	static Queue q = new LinkedList(); //LinkedList로 만들지 않는 이유는 Queue속에 다양한 링크드리스트를 나중에 한번에 모아서 사용할 수 있기때문
	static final int MAX_SIZE = 5; //큐에 최대 5개까지만 저장되도록 한다.
	
	public static void main(String[] args)
	{
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true){
			System.out.print(">>");
			try{
				//화면으로부터 라인단위로 입력받는다.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();//trim은 위에 공백문자같은게 쳐졌으면 자르는것.
				
				if("".equals(input)) continue; //아무것도 안치면 다시 입력창에 입력대기
				
				if(input.equalsIgnoreCase("q")) //q 입력하면 시스템종료
				{
					System.exit(0);
				}
				else if(input.equalsIgnoreCase("help"))
				{
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다.");
					System.out.println("history - 최근에 입력한 명령어를"+MAX_SIZE+"개를 보여줍니다.");
				}
				else if(input.equalsIgnoreCase("history"))
				{
					int i=0;
					//입력받은 history명령어도 저장되고,
					save(input);
					//LinkedList 의 내용을 보여준다.
					LinkedList tmp = (LinkedList)q; //아까위에서 클래스타입을 Queue로 했기때문에 캐스팅해주는 것.
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext())//hasNext() 현재커서 다음에 데이터가 있는지 확인하는 메소드 (T/F)
					{
						System.out.println(++i+"."+it.next());//next() 커서가 가리키고있는 곳의 데이터
					}
				}
				else
				{
					save(input); //내가입력한 값들이 계속저장되는 것.
					//System.out.println(input);->있으니까 오히려 헷갈려서 주석처리해놈
				}//if(input.equalsIgnorCase("q")){
			}catch(Exception e)
			{
				System.out.println("입력오류입니다");
			}
		}//while(true)
	}//main()
	
	public static void save(String input)
	{
		if(!"".equals(input))
			q.offer(input);
			
		if(q.size()>MAX_SIZE) //size()는 Collection인터페이스에 정의
			q.remove(); //큐는 FIFO 그래서 용량차서 버릴때도 가장먼저들어와있던애들부터 지움
	}
}
