package util;

public class Array {
	public static int[] sort(int[] a) {

		// 원본 보존하기 위해 a2에 배열 복사
		int[] a2 = new int[a.length];
		System.arraycopy(a, 0, a2, 0, a.length);

		// sorting
		int temp;
		for (int i = 0; i < a2.length - 1; i++) {
			for (int j = i + 1; j < a2.length; j++) {
				if (a2[i] > a2[j]) {
					temp = a2[i];
					a2[i] = a2[j];
					a2[j] = temp;
				}
			}
		}
		
		//정렬한 데이터를 리턴
		return a2;
	}
}
