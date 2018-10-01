package day27;		//프로젝트 통째로 말고 파일만 옮기면 다른 컴퓨터에서도 실행해볼 수 있는데 이때 똑같은 패키지를 만들어놓던가 아니면 아예지우던가 아니면 새로만든 패키지명으로 바꿔주던가 해야 
					//에러가 안난다~~(꿀팁!)

public class day27Ex3 { // 채워진 마름모로 별찍기

	public static void main(String[] args) {
		int n=10;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i < 5) {
					if (j >= n/2 - i && j <= n/2 + i) {
						System.out.print("* ");
					} else
						System.out.print("  ");
				}
				else
				{
					if(j>=i-n/2 && j<=n-i+n/2)
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
