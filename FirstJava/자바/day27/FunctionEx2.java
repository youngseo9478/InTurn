package day27;

import java.util.Scanner;

public class FunctionEx2 { //값을 세개 입력받아서 평균을 내는 함수를 만들어서 평균값을 받아서 출력하는 프로그램

		public static void main(String[] args)
		{
			int kor,eng,math;
			
			Scanner sc = new Scanner(System.in);
			kor = getscore("국어", sc);
			eng = getscore("영어", sc);
			math = getscore("수학", sc);
			
			/*Scanner sc = new Scanner(System.in);
			
			System.out.println("국어점수를 입력해주세요 >");		//이부분들도 함수로 만들어 줄 수 있다. 반복되니까!
			kor = sc.nextInt();		//sc.nextInt()는...
			
			System.out.println("영어점수를 입력해주세요 >");
			eng = sc.nextInt();
			
			System.out.println("수학점수를 입력해주세요 >");
			math = sc.nextInt();
			*/
			System.out.print("나의 평균점수는 :");		//자바에서 소수는 디폴트가 double~!!
			double average = avr(kor,eng,math);		//이렇게 나눠서 써도 되고 출력때 한번에 println(avr(kor,eng,math));해도 되고, ("평균:"+average);해도됨.
			System.out.println(average);            //입력받은 국어,영어,수학점수를 매개변수로 평균을 구하는 함수
			
			sc.close();	//sc할당을 해제하는 건가..?
		
			
		}
		
		public static int getscore(String subjectName, Scanner sc)
		{
			int num = 0;
			System.out.println(subjectName+"점수를 입력해주세요 >");
			num = sc.nextInt();
			
			return num;
		}
		public static double avr(int a, int b, int c)
		{
			double result=(a+b+c)/3.0;	//그냥 3하면 정수형으로 계산되어서 소수점아래자리가 날아간다. 하나만이라도 실수값으로 해주면 계산도 실수로 계산되어 나온다.
			return result;		//result=a+b+c이면 return result/3; 해도 됨 
		}
}
