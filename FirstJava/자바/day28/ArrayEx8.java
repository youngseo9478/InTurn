package day28;

import java.util.Scanner;

public class ArrayEx8 {

	public static void main(String[] args) {
		String[][] words = { 
								{ "chair", "의자" }, 
								{ "computer", "컴퓨터" }, 
								{ "integer", "정수" } 
							};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<words.length;i++)
		{
			System.out.println("Q"+(i+1)+". "+words[i][0]+"의 뜻은?");
			String tmp = sc.nextLine().trim(); //문자열 입력받는것.
			if(tmp.equals(words[i][1]))
			{
				System.out.println("정답입니다.");
			}
			else
			{
				System.out.println("틀렸습니다. 정답은 "+words[i][1]);
			}
		}
		sc.close();
	}
}
