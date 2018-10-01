package day3_7;
import java.util.Date;	//Date클래스를 갖고있는 패키지
import java.util.Scanner;	//스캐너클래스와 hasNextLine()메소드를 갖고있는 패키지
import java.util.Calendar;	//Calendar에 필요한 패키지
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DateFormatEx2 {

	public static void main(String[] args)
	{
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("날짜를 "+pattern+"의 형태로 입력해주세요.");
		
		while(s.hasNextLine()) //받아올 문자가 있는지 확인하는 것 Scanner의 패키지에 ㅗ포함된 것.
		{
			try{
				inDate = df.parse(s.nextLine());	//내가 입력한 값을 Date형태로 받아서 inDate에 저장
				break;
			}catch(Exception e){
				System.out.println("날짜를"+pattern+"형태로 다시 입력해주세요.");// 슬래쉬가아닌 다른걸로 표기할 경우 알맞은 패턴으로 입력해달라고 요청하는 것.
			}
		}//while
		
		Calendar cal = Calendar.getInstance(); //Calendar 클래스의 객체를 생성하는 방법. new를 안씀! 주의
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long day = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000);
		
		System.out.println("입력하신 날짜는 현재와"+day+"시간 차이가 있습니다.");
		s.close(); //scanner받은거 닫아주는....
	}//main
}
