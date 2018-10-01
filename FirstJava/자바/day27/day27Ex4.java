package day27;

public class day27Ex4 {		//이게 과제3번 제너릭한 버전

	public static void main(String[] args) {
		
		int n=17;
		int a=n;
		int b=n/2;
			
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i <= b) {
					if (j >= b - i && j <= b + i) {
						System.out.print("* ");
					} else
						System.out.print("  ");
				}
				else
				{
					if(j>=i-b && j<a-i+b)
					{
						System.out.print("* ");
					}
					else
						System.out.print("  ");
				}		//제너릭하게 푸는 방법은 숙제!! 사이즈가 바뀌어도 가능하게 
						//지금은 10이나 9 이런거만 제대로 나오는 상황!! 
			}
			System.out.println();
		}
	}
}
