package prob;

/**
 * 
 * @author 원영서
 * @since 2017.11.09
 *
 */
public class BookMgr {

	Book[] bookList = new Book[50];
	int count = 0;
	// count : 배열의 인덱스를 관리하기위한 변수로 도서의 개수와 동일

	/**
	 * 기본 생성자
	 */
	public BookMgr() {

	}

	/**
	 * bookList라는 배열 변수를 초기화하는 생성자 메소드
	 * 
	 * @param booklist
	 */
	public BookMgr(Book[] booklist) {
		for (int i = count; i < booklist.length; i++) {
			this.bookList[i] = booklist[i];
		}
		count += booklist.length;
	}

	/**
	 * Book객체를 bookList에 등록하는 메소드
	 * 
	 * @param book
	 */
	public void addBook(Book book) {

		this.bookList[count] = book;
		count++;
	}

	/**
	 * 신간 도서 리스트를 등록하는 메소드
	 * 
	 * @param booklist
	 *            : 추가할 도서 리스트
	 */
	public void addBookList(Book[] booklist) {
		for (int i = count; i < booklist.length; i++) {
			this.bookList[i] = booklist[i];
		}
		count = count+ booklist.length;
	}

	/**
	 * 도서 목록을 출력하는 메소드
	 */
	public void printBookList() {
		System.out.println();
		System.out.println("============ 도서 목록============");
		for (int i = 0; i < count; i++) {
			System.out.println(bookList[i].getTitle());
		}
	}

	/**
	 * 검색한 도서의 가격정보를 출력하는 메소드
	 * @param title : 검색한 도서명
	 */
	public void printPrice(String title) {
		if (count == 0) {
			System.out.println("리스트가 존재하지 않습니다.\n도서를 추가해주세요");
			System.out.println();
			return;
		} else {
			for (int i = 0; i < count; i++) {
				if (bookList[i].getTitle().equals(title)) {
					System.out.print("▶검색하신 도서 : ");
					System.out.println(bookList[i].getTitle());
					System.out.print("▶가격 정보 : ");					
					System.out.println(bookList[i].getPrice());
				}
			}
		}
	}
	
	public void removeBook(String title){
		for (int i = 0; i < count; i++) {
			if(bookList[i].getTitle().equals(title)){
				for (int j = i+1; j < count; j++) {
					bookList[i]=bookList[j];					
				}
				count--;
				break;
			}
		}
	}

	/**
	 * 보유중인 도서의 가격 합계
	 */
	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		System.out.println();
		System.out.println("=== 책 가격의 총합 ===");
		System.out.printf("▶모든 책 가격의 합 : %d%n", sum);
	}

}
