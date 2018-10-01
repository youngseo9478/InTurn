package day3_7;

import java.util.*;

public class PackageCalendarEx2 {

	public static void main(String[] args) {
		final int[] TIME_UNIT = { 3600, 60, 1 };// 큰 단위를 앞에 놓는다.(시,분,초)
		final String[] TIME_UNIT_NAME = { "시간", "분", "초" };

		Calendar time1 = Calendar.getInstance();// Calendar는 instance(객체)를 이렇게
												// 생성한다는 것 알아두기
		Calendar time2 = Calendar.getInstance();

		// time1의 시간을 10시 20분 30초로 설정한다.
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		// time2의 시간을 20시 30분 10초로 설정한다.
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);

		System.out.println("time1 :" + time1.get(Calendar.HOUR_OF_DAY) + "시" + time1.get(Calendar.MINUTE) + "분"
				+ time1.get(Calendar.SECOND) + "초");
		System.out.println("time2 :" + time2.get(Calendar.HOUR_OF_DAY) + "시" + time2.get(Calendar.MINUTE) + "분"
				+ time2.get(Calendar.SECOND) + "초");

		//getTimeInMillis()는 1/1000 초 값을 반환하기때문에 이를 1000으로 나눠주어야 초가 나온다.그리고 리턴형이 long이다.
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;

		System.out.println("time1과 time2의 차이는 " + difference + "초 입니다.");

		String tmp = ""; // tmp는 문자열에 해당하는 것.
		for (int i = 0; i < TIME_UNIT.length; i++) {
			tmp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i]; // 시간을 초로 받아서 그걸 3600초로 나누면 시간이 나오고 나눈
										// 나머지는 또다시 60으로 나누면 분이되고 그의 나머지는 초가
										// 되는것. tmp가 문자열 변수기때문에 for문을 통해 계속
										// 더해지면서 숫자와 시,분,초가 모두
										// 문자열로 합쳐져서 표현될 수 있는것
		}
		System.out.println("시분초로 변환하면 " + tmp + "입니다.");
	}
}
