package book.ver02;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {

		ArrayList<Book> books2 = new ArrayList<Book>();
		books2.add(new Book("딩스뚱스",2000));
		books2.add(new Book("신1",18000));
		books2.add(new Book("신2",18000));
		books2.add(new Book("신3",18000));
		books2.add(new Book("신4",18000));
		
		BookMgr manager = new BookMgr(books2);
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean flag = true;
		String fileName;

		String title;

		while (flag) {
			System.out.println("_____________________________");
			System.out.println("1. 소장 도서 목록 보기			");
			System.out.println("2. 도서 추가하기(1권)	");
			System.out.println("3. 고객 요청 도서 리스트 추가	");
			System.out.println("4. 도서 정보 검색				");
			System.out.println("5. 삭제하기				");
			System.out.println("6. 종료하기				");
			System.out.println("_____________________________");
			System.out.print("원하는 작업을 선택하세요☞");
			num = Integer.parseInt(sc.nextLine().trim());

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
				int price = Integer.parseInt(sc.nextLine().trim());
				manager.addBook(new Book(title, price));
				manager.printBookList();

				break;
			case 3:
				System.out.printf("추가 가능한 고객 요청 리스트 파일명을 입력하세요( addbook1.txt 또는 addbook2.txt) : ");
				fileName = sc.nextLine().trim();
				manager.addBookList(fileName);
				break;
			case 4:
				System.out.print("가격을 알고싶은 도서의 이름을 입력하세요 : ");
				title = sc.nextLine().trim();
				manager.printPrice(title);
				System.out.println();
				break;
			case 5:
				System.out.print("삭제를 원하는 도서를 입력해주세요 : ");
				title = sc.nextLine().trim();
				manager.removeBook(title);
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
