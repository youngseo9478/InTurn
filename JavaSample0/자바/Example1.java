package day29;

/*10개짜리 배열만들고 난수를 발생시켜서 배열에 넣고 이것을 정렬하는 것 오름차순으로!*/

//***버블소트 버전***(난이도 하)
public class Example1 {

	public static void main(String[] args) {
		int random = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			random = (int) (Math.random() * 10);
			arr[i] = random;
		}
		System.out.println("난수 발생시킨 배열");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("==========");

		int tmp = 0;
		int count = arr.length;
		// 반복횟수를 하나씩 줄여줘야 한다. 맨뒤에 최솟값이 자리잡으면 이제 9개를 비교하고 두번째 큰수까지 잡리잡으면 다음은 8개의
		// 숫자를 비교하고! 이런식이니까
		for (int i = count - 1; i > 0; i--) {
			// j는 1부터 시작해주는게 중요한데 0부터하게되면 j-1은 음수가 나와서 에러가 난다.
			for (int j = 1; j < count; j++) {
				if (arr[j - 1] > arr[j]) {
					tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
			
			/*//j를 0부터해서 count-1까지로하면
			 * for (int j = 0; j < count-1; j++) {
				if (arr[j+1] < arr[j]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}*/
		}
		System.out.println("오름차순으로 정렬된 배열");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}
}
