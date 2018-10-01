package day3_7;

import java.util.*;
import java.text.*;

public class DateFormatEx {

	public static void main(String[] args) {
		Date today = new Date(); // Date는 util클래스에있음. Calendar안에 있는거 X Date 클래스를
									// 이용해 today라는 객체를 만듬.
		//Date()는 Allocates a Date
		// object and initializes it so that it
		// represents the time at which it was
		// allocated, measured to the nearest
		// millisecond.
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4; //text 패키지에 있는 클래스
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");

		System.out.println(sdf1.format(today));// format(Date d)
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}
}
