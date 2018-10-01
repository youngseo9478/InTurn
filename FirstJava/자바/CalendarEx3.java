package day3_7;
//import java.util.*; //util안에거를 다 가져오는건데 이러면 너무 커져서 비효율적
import java.util.Calendar;

public class CalendarEx3 {

	public static void main(String[] args)
	{
		Calendar date = Calendar.getInstance();
		date.set(2014, 1,19);// 2005.8.31 MONTH는 0~11이니까
		
		System.out.println(toString(date));
		System.out.println("==1230일 후==");
		date.add(Calendar.DATE, 1230);	//DATE : the day of the month.
		System.out.println(toString(date));
		
		System.out.println("==6달 전==");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("==31일 후(roll)=="); 
		date.roll(Calendar.DATE, 31);//정해진 범위보다 더 커지거나 더 작아질때 자리올림을 하지않고 그 자리만을 변화시키는 메소드(roll)
		System.out.println(toString(date));
		
		System.out.println("==31일 후(add)==");
		date.add(Calendar.DATE, 31);//정해진 범위보다 더 커지거나 더 작아질때 자리올림을 하는 메소드(add)
		System.out.println(toString(date));		
	}
	
	public static String toString(Calendar date)
	{
		return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1)+"월 "+date.get(Calendar.DATE)+"일";
	}
}
