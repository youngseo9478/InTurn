package day4_7;

/*초이스포맷
 * 유용한 클래스 중 하나
 * ChoiceFormat은 특정 범위에 속하는 값을 문자열로 변환해준다. 
 * 연속적 또는 불연속적인 범위의 값들을 처리하는데 있어서 if문이나 switch문은 적절하지 못한 경우가 많다. 
 * 이럴때 ChoiceFormat을 잘 사용하면 복잡하게 처리될 수 밖에 없었던 코드를 간단하고 직관적으로 만들 수 있다.*/
//import java.util.*;
import java.text.*;

public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double[] limits = { 60, 70, 80, 90 }; // 낮은 값부터 큰 값의 순서로 적어야한다.
		String[] grades = { "D", "C", "B", "A" };// limits과 grades간의 순서와 개수를 맞춰야
													// 한다.

		int[] scores = { 100, 95, 88, 70, 52, 60, 70 };
		// 초이스 포맷은 limit과 grade를 받아서 기준을 잡고 그 객체의 포함된 format메소드를 이용해서 비교하여 등급을
		// 매길 수 있다.
		ChoiceFormat form = new ChoiceFormat(limits, grades);

		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i] + " : " + form.format(scores[i]));
		}
		System.out.print("===================");
		System.out.println();
		// 네트워킹에서는 위에처럼 일일이 기준을 잡아주기가 헷갈려서 패턴형식으로 많이 만든다.
		String patter = "60#D|70#C|80#B|90#A"; // 문자열 패턴을 만들어 보내준 것으로 결과는 같음
		ChoiceFormat form2 = new ChoiceFormat(patter);
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i] + " : " + form2.format(scores[i]));
		}
	}
}
