package day28;

public class ArrayEx5 {
	// 배열 활용 코드
	public static void main(String[] args) {
		int[] korNum = { 87, 94, 56, 76, 94, 78, 86, 56, 69, 55 };
		int[] mathNum = { 87, 97, 56, 76, 84, 78, 86, 56, 69, 55 };
		int[] engNum = { 87, 98, 56, 76, 53, 78, 86, 56, 69, 55 };

		int totalKor = 0, totalMath = 0, totalEng = 0;

		for (int i = 0; i < korNum.length; i++) {
			totalKor += korNum[i];
			totalMath += mathNum[i];
			totalEng += engNum[i];
		}

		System.out.println("학생들의 수학 평균 : " + (totalMath / 3.0)); // 사칙연산하면
																	// int형이지만
																	// 3.0넣어주면
																	// 결과가
																	// double로
																	// 출력되는 것.**
		System.out.println("학생들의 영어 평균 : " + (totalEng / 3.0));
		System.out.println("학생들의 국어 평균 : " + (totalKor / 3.0));

		int korMax = 0, engMax = 0, mathMax = 0; // 최대값을 담을 변수를 과목별로 각각 선언해준다
													// 최대값을 알고 싶을 때는 0으로 초기화하고,
													// 최소값을 알고 싶을 때는 100으로
													// 초기화해야한다.

		int tmp =0;
		//swap하는 방법도 있다.->완성안됨 다시 수정하기 틀렸음
		for (int i = 1; i < korNum.length; i++) {
			if (korNum[i] > korNum[i-1]) 
			{
				tmp=korNum[0];
				korNum[i-1]=korNum[i];
				korNum[i]=tmp;
			}
			if (engNum[i] > engNum[i-1]) 
			{
				tmp=engNum[i-1];
				engNum[i-1]=engNum[i];
				engNum[i]=tmp;
			}
			if (mathNum[i] > mathNum[i-1]) 
			{
				tmp=mathNum[i-1];
				mathNum[i-1]=mathNum[i];
				mathNum[i]=tmp;
			}
		}
		System.out.println();
		System.out.println("국어1등 점수 : " + korNum[0]);
		System.out.println("영어1등 점수 : " + engNum[0]);
		System.out.println("수학1등 점수 : " + mathNum[0]);
		
		for (int i = 0; i < korNum.length; i++) {
			if (korNum[i] > korMax) // 최소값을 구하는 것이라면 부등호가 반대여야한다.
				korMax = korNum[i];
			if (engNum[i] > engMax)
				engMax = engNum[i];
			if (mathNum[i] > mathMax)
				mathMax = mathNum[i];
		}
		System.out.println();
		System.out.println("국어1등 점수 : " + korMax);
		System.out.println("영어1등 점수 : " + engMax);
		System.out.println("수학1등 점수 : " + mathMax);
	}
}
