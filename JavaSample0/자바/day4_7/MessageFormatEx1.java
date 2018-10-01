package day4_7;
/*메세지 포맷
 * 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와주는 클래스입니다.
데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를
같은 양식으로 출력할 때 사용하면 좋습니다.
*/

import java.text.MessageFormat;
import java.text.ParseException;
//import java.util.*;

public class MessageFormatEx1 {

	public static void main(String[] args)
	{
		//값을 집어 넣는 것.
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO "+tableName+" VALUES(''{0}'',''{1}'',{2},''{3}'');"; //쿼리(데이터베이스언어)에서는 ' '이 문자열
		
		Object[][] arguments = {
				{"이자바","02-123-1234","27","07-09"},
				{"김프로","032-333-1234","33","10-07"}
		};
		
		for(int i=0; i<arguments.length;i++) //arguments.length는 2니까 0,1까지
		{
			String result = MessageFormat.format(msg,arguments[i]); //왼쪽에 오른쪽 값을 대입해주는것...?
			System.out.println(result);
		}
		
		//값을 나타내는 것(위와 역 파싱)->패턴이용한 방법
		String[] data = {//인덱스 0,1
				"INSERT INTO CUST_INFO VALUES('이자바','02-123-1234',27,'07-09');",
				"INSERT INTO CUST_INFO VALUES('이자바','02-123-1234',27,'07-09');"
		};
		
		String pattern = "INSERT INTO CUST_INFO VALUES({0},{1},{2},{3});"; //0,1,2,3에 들은 값을 빼오는 것.
		MessageFormat mf = new MessageFormat(pattern);
		
		for(int i=0; i<data.length; i++) //date.length=2니까 i=0,1 까지 가능
		{
			Object[] objs = null;
			try{
				objs = mf.parse(data[i]);
			}catch(ParseException e){
				e.printStackTrace();
			}	
			for(int j=0; j<objs.length;j++)
			{
				System.out.print(objs[j]+",");
			}
			System.out.println();
		}
	}
}
