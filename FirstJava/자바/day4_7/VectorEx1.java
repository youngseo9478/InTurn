package day4_7;
/*##Vector##
 * 벡터의 생성자에는 */
import java.util.*;
import static java.lang.System.out;

public class VectorEx1 {

	public static void main(String[] args)
	{
		Vector<Double> v = new Vector<Double>(2,5); //처음에는 2개짜리 배열을 할당하는데 공간이 부족하면 5개씩 추가시키는 것
		
		v.add(100.2);
		v.add(3.14); //여기까지는 capacity = 2
		v.add(1000.0); //얘 넣으려면 v의 크기가 커져야 함 ->5개 공간이 더 증가 -> 현재 capacity = 7
		
		for(Double n : v)
		{
			out.println(n);
		}
		
		double search = 1000.0;
		int index = v.indexOf(search); //search값이 들어있는 인덱스 값을 리턴하는 메소드
		
		if(index != -1)
		{
			out.println("검색요소"+search+"의 위치 : "+index);
		}else
		{
			out.println("검색요소"+search+"가 없습니다.");
		}
		
		out.println("::::::::::::::: 삭제전 용량/크기 :::::::::::::::");
		out.println("capacity : "+v.capacity()); //capacity() 저장할 수 있는 용량의 크기
		out.println("size : "+v.size()); //size() 그 안에 갖고있는 객체(원소)의 수
		
		double del= 3.14;
		if(v.contains(del))
		{
			v.remove(del);
			out.println(del+" 삭제완료!!!");
		}
		
		out.println("::::::::::::::: 삭제후 용량/크기 :::::::::::::::");
		out.println("capacity : "+v.capacity());
		out.println("size : "+v.size());
		
		v.trimToSize(); //지금 사용하는 공간 외에 남은 공간 있으면 자르는 것.(메모리할당해제)
		out.println("::::::::::::::: 용량 조절 후 용량/크기 :::::::::::::::");
		out.println("capacity : "+v.capacity());
		out.println("size : "+v.size());
	}
}
