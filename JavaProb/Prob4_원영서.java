package day5;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("암호화할 문자열을 입력하세요 : ");
		String crypt = scanner.nextLine();
		scanner.close();
		char change;
		for (int i = 0; i < crypt.length(); i++) {
			if (crypt.charAt(i) != ' ') {
				change = crypt.charAt(i);
				if (89<=change&&change<=91||120<=change&&change<=122) {
					System.out.print((char) (change - 23));
				} else {
					System.out.print((char) (change + 3));
				}
			}
			else{
				System.out.print(crypt.charAt(i));
			}
		}
	}
}
