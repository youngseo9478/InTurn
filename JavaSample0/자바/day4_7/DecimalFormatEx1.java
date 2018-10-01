package day4_7;

/*숫자를 원하는 형식으로 출력할 수 있게 매칭하는 것 
 * =>DecimaFormat
 * 
 * 굉장히 유용한 코드임으로 꼭 갖고 있기!!*/
import java.text.*;

public class DecimalFormatEx1 {

	public static void main(String[] args) {
		double number = 1234567.89;

		String[] pattern = { // 문자열타입의 배열
				"0", 
				"#", 
				"0.0", 
				"#.#", 
				"0000000000.0000", 
				"##########.####", 
				"#.#-", 
				"-#.#", 
				"#,###.##", 
				"#,####.##",
				"#E0", 
				"0E0", 
				"##E0", 
				"00E0", 
				"####E0", 
				"0000E0", 
				"#.#E0", 
				"0.0E0", 
				"0.00000000E0", 
				"00.0000000E0",
				"000.000000E0", 
				"#.########E0", 
				"##.#######E0", 
				"###.######E0", 
				"#,###.##+;#,###.##-", 
				"#.#%",
				"#.#\u2030", 
				"\u00A4 #,###", //\u00A4 =>원 표시
				"'#'#,###", 
				"''#,###" 
				};

		for (int i = 0; i < pattern.length; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.printf("%19s : %s\n", pattern[i], df.format(number)); // 19자리로
																				// 뽑을거라
																				// 여기서는
																				// C언어로
																				// 표현해서
																				// 출력하는게
																				// 편하기때문에
																				// %s
																				// 문자열형식나타내고
																				// print
		}
	}
}
