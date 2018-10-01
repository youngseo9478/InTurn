package day3_7;
/*calendar class
 * get() 소괄호안에 필드들이 들어가는데
 * 필드가 굉장히 다양함.그런데 그 중에
 * MONTH는 범위가 0~11이니까 넣을때랑 출력할 때 모두 +1해줘야하는거 주의하기
 * */
import java.util.Calendar;
public class PackageCalendar {

	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer("오늘 날짜 : ");
		Calendar cTime = Calendar.getInstance();
		
		int year = cTime.get(Calendar.YEAR);
		int month = cTime.get(Calendar.MONTH)+1;
		int day = cTime.get(Calendar.DAY_OF_MONTH);
		
		sb.append(year);
		sb.append("년 ");//append는 이어붙이는 것.
		sb.append(month);
		sb.append("월 ");
		sb.append(day);
		sb.append("일 ");

		System.out.println(sb.toString()); //toString은 뭐더라..
	}
}
