import java.util.*;

class CalendarEx10 {
	public static void main(String[] args) {
		System.out.println("2004. 5. 31 :" + getDayOfWeek(2004, 5, 31)); // 이 날이
																			// 그
																			// 주의
																			// 몇번
																			// 째
																			// 날인지
																			// 나타내는
																			// 메소드
		System.out.println("2002. 6. 1 :" + getDayOfWeek(2002, 6, 1)); // 이 날이 그
																		// 주의 몇번
																		// 째 날인지
																		// 나타내는
																		// 메소드
		System.out.println("2004. 5. 1 - 2004.4.28 :" + dayDiff(2004, 5, 1, 2004, 4, 28)); // 4/28과
																							// 5/1의
																							// 차이를
																							// 구하는
																							// 메소드
		System.out.println("2005. 6. 29 : " + convertDateToDay(2005, 6, 29)); // 년월일을
																				// 입력받아서
																				// 일단위로
																				// 변환하는
																				// 함수(처음시스템시간으로부터의
																				// 일
																				// 수)
		System.out.println("732126 : " + convertDayToDate(732126)); // 일 수를
																	// 입력받아서
																	// 년월일로 변환하는
																	// 함수
	}

	// 각 달의 마지막 날을 배열에 넣어놓음 ->index는 1월이 0에 해당~ 12월은 11
	public static int[] endOfMonth = { 31/* 1월 */, 28/* 2월 */, 31/* 3월 */, 30/* 4월 */, 31/* 5월 */, 30/* 6월 */,
			31/* 7월 */, 31/* 8월 */, 30/* 9월 */, 31/* 10월 */, 30/* 11월 */, 31/* 12월 */ };

	// 윤년인지 평년인지 구하는 것 (*윤년 2/29가 있는 해)
	public static boolean isLeapYear(int year) {// 경우의수가 2가지 뿐이니까 boolean 타입
		/*
		 * 윤년계산법 ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, ② 그 중에서 100으로 나누어 떨어지는
		 * 해는 평년으로 하며, ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.
		 */
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}

	// 날짜 차이를 계산한는 메소드
	public static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) {
		return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);

	}

	// 년,월,일을 받아 그 주의 몇번 째 날인지 계산하는 메소드
	public static int getDayOfWeek(int year, int month, int day) {

		return convertDateToDay(year, month, day) % 7 + 1;
	}

	// 총 일수를 입력받아 몇 년도 몇 월 며칠 인지 구해내는 메소드 (최초의시스템시간을 기준으로 일수를 계산)
	public static String convertDayToDate(int day) {
		int year = 1;
		int month = 0;

		int numOfLeapYear = 0;
		while (true) {// 몇 년인지 구하기 위한 반복문
			int aYear = isLeapYear(year) ? 366 : 365; // boolean타입이었으니까 윤년이면 참,
														// 평년이면 거짓의 값을 받음.
			// 1년을 일 수, 즉366 or 365로 나타내어 입력받는 일 수 중에서 1년에 해당하는 일 수 씩 빼며 년에
			// 1씩더한다.
			if (day > aYear) {
				day -= aYear;
				year++;// 1이 증가한 year의 값은 위의 isLeapYear 메소드에서 반복해서 윤년인지 평년인지
						// 결정됨.
			} else {// 남아있는 day의 값이 366 or 365보다 작으면 이제 달을 계산하기 위해 while문을
					// break; 해준다.
				break;
			}
		}

		while (true) {// 몇 월인지 구하기 위한 반복문
			int endDay = endOfMonth[month];// endOfMonth[0]으로 endDay를 초기화 시킨다.
											// ->0월이 아니라 1월임을 주의!

			// (month==1 ->2월) 2월이면서 윤년이면, 총 일 수가 28에서 29로 증가시켜야함.
			if (isLeapYear(year) && month == 1)
				endDay++;// 2월의 총 일 수 는 default가 28이었는데 1증가시켜서 29가 된 것.

			// (위와 별개의 if문) 몇 년일지를 구할 때와 마찬가지로 초기화된 month의 마지막 날보다 day값이 더 크다면
			// 월을 1증가 시킴
			if (day > endDay) {
				day -= endDay;
				month++;
			} else {// day<=endDay 라면 while문을 종료 -> 남은 day의 값을 통해 며칠인지를 알 수 있음.
				break;
			}
		}
		// convertDayToDate()메소드는 몇년-몇월-며칠을 리턴값으로 던져줌
		return year + "-" + (month + 1) + "-" + day;
	}

	// convertDayToDate()메소드와 반대로 몇년 몇월 며칠을 입력받으면 시스템시간으로부터의 일 수를 나타내는 메소드
	public static int convertDateToDay(int year, int month, int day) {
		int numOfLeapYear = 0;// 윤년을 0번으로 초기화해놓고 시작

		for (int i = 1; i < year; i++) {// i<=year까지가 아닌 이유는?? 지난해의 일 수 까지만 구하는
										// 것이기 때문에 현재 해당하는 해는 윤년인지 계산하면 안됨. 아래에서
										// 윤년이었던 횟수만큼 더해주게되는데 여기서 오류가 발생함
			if (isLeapYear(i))// i년도가 윤년이면 1증가시키는 것.
				numOfLeapYear++;
		}

		// (year-1)인 이유는 ? 2014.7.31이면 2013*365를 구하고 그 해의 일 수를 계산해서 더해야 총 일 수를 알
		// 수 있음.
		int toLastYearDaySum = (year - 1) * 365 + numOfLeapYear;// 윤년이었던 횟수만큼
																// 더해주면 366일이었던
																// 해도 정확한 일 수 를
																// 세어줄 수 있다.

		int thisYearDaySum = 0;// 올 해의 일수는 0으로 초기화해놓고 시작

		for (int i = 0; i < month - 1; i++) {// month의 인덱스가 0~11까지인데 또
												// month-1보다 작을때까지만 반복하는
												// 이유는..?여기의
												// month는 그 month가 아님! 우리가 입력한
												// month임. 각 달의 마지막 날을 넣어놓은 배열을
												// 이용하려면 month-1이 되어야 하는 것인데
												// 여기에다가 추가로 해당하는 월의 전 월의 마지막
												// 날까지만 더해져야하기때문에 결국 i값은
												// month-2까지만 증가하는 것.

			thisYearDaySum += endOfMonth[i];
		}

		// 해당하는 날짜가 윤년에 해당하면서 2월이 넘은 시점이라면 +1을 해줘야 하는 것. (위에서 현재해당하는 해 전까지만 윤년
		// 계산을 해주었기 때문 ->현재 해당하는 년도가 윤년이더라도 1,2월이라면 1을 더해줄 필요가 없기때문
		if (month > 2 && isLeapYear(year)) {
			thisYearDaySum++;
		}

		thisYearDaySum += day;

		//convertDateToDay()메소드는 지난해까지의 일 수와 이번 해가 시작되고서 지난 일 수를 더한 값, 즉 총 일수를 리턴한다.
		return toLastYearDaySum + thisYearDaySum;
	}
}