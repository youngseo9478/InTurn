package day19.prob;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prob2 {
	public static void main(String[] args) {

		String str = "PROD-001#X-note#Samsung#3#6000000";
		Set<String> strs = stringSplit(str, "#");
		System.out.println("=== 문자열 처리 결과 ===");

		Iterator<String> it = strs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static Set<String> stringSplit(String str1, String str2) {
		char[] data = str1.toCharArray();
		Set<String> set = new HashSet<>();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < data.length; i++) {
			if (data[i]==str2.charAt(0)) {
				set.add(sb.toString());
				sb = new StringBuffer("");
			} else {
				sb.append(data[i]);
			}
		}
		set.add(sb.toString());
		return set;
	}
}
