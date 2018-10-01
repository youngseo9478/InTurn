package prob;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {

		Book[] books = { new Book("자바의정석", 30000), new Book("java", 15000), new Book("sql", 22000) };
		Book[] books2 = { new Book("라푼젤", 30000), new Book("뺴뺴로", 17000), new Book("QA", 20000) };
		BookMgr manager = new BookMgr(books);

		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean flag = true;
		String title;

		while (flag) {
			System.out.println("---------------영서 서점-----------------");
			System.out.println("|1. 소장 도서 목록 보기			|");
			System.out.println("|2. 고객 요청 도서 추가하기(1권)		|");
			System.out.println("|3. 신간 리스트 추가(1권~여러권)	|");
			System.out.println("|4. 도서 정보 검색			|");
			System.out.println("|5. 삭제하기			|");
			System.out.println("|6. 종료하기				|");
			System.out.println("-----------------------------------------");
			System.out.print("원하는 작업을 선택하세요☞");
			num = Integer.parseInt(sc.nextLine());
			System.out.println();

			switch (num) {
			case 1:
				manager.printBookList();
				System.out.println();
				System.out.println();
				break;
			case 2:
				System.out.print("도서명을 입력해주세요 : ");
				title = sc.nextLine();
				System.out.print("해당 도서의 금액을 입력해주세요 : ");
				int price = Integer.parseInt(sc.nextLine());
				manager.addBook(new Book(title, price));
				System.out.println();
				System.out.printf("▶%s 입고◀", title);
				System.out.println();
				manager.printBookList();

				break;
			case 3:
				manager.addBookList(books2);
				System.out.println("▶신간 도서 리스트 입고◀");
				System.out.println();
				break;
			case 4:
				System.out.print("가격을 알고싶은 도서의 이름을 입력하세요 : ");
				title=sc.nextLine();
				System.out.println();
				manager.printPrice(title);
				System.out.println();
				break;
			case 5:
				System.out.print("삭제를 원하는 도서를 입력해주세요 : ");
				title = sc.nextLine();
				manager.removeBook(title);
				manager.printBookList();
				System.out.println();
				break;
			case 6:
				flag = false;
				System.out.println("▶실행을 종료합니다~~");
				System.exit(0);
				System.out.println();
			default:
				System.out.println("▶1~5번 중에 선택해주세요^^");
				break;

			}
		}
		sc.close();
	}
}
