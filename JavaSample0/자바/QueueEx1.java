package day5_7;
/**********LinkedList***********/
/*스택과 다르게 집어넣은 순서대로 출력된다.*/
import java.util.LinkedList;
public class QueueEx1 {
	public static void main(String[] args)
	{
		String[] strArr = {"노트북","자동차","TV","스마트폰"};
		LinkedList<String> llist = new LinkedList<String>();
		
		for(String item : strArr)
		{//배열에 넣었던 값들을 링크드리스트로 하나씩 넣어주는 과정
			llist.offer(item);// 아이템을 추가하는 메소드
		}
		System.out.println("queue size : " + llist.size());
		String data = ""; //data 변수 선언하면서 초기화
		while((data=llist.poll())!=null) //값을 하나씩 빼내는 메소드
		{//빼낸값이 없지않다면 계속 반복하는 것. ->큐에서 모든 데이터 꺼냈으면 break한다는 뜻
			System.out.println(data);
		}
		System.out.print("======모두 poll()한 후======\n");
		System.out.println("queue size : "+llist.size());
	}
}
