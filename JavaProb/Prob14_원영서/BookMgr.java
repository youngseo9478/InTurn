package book.ver02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *
 */
public class BookMgr {

	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Book> books = new ArrayList<Book>();
	int count = 0;

	public BookMgr() {
	}

	public BookMgr(ArrayList<Book> bookList) {
		super();
		this.bookList.addAll(bookList);
	}

	/**
	 * 1.도서 목록을 출력하는 메소드
	 */
	public void printBookList() {
		System.out.println();
		System.out.println("============ 도서 목록============");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.printf("[%d	%s]%n", i + 1, bookList.get(i).getTitle());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * 2.Book객체를 bookList에 등록하는 메소드
	 * 
	 * @param book
	 */
	public void addBook(Book book) {

		bookList.add(book);
		System.out.println();
		System.out.printf("▶%s 입고◀", book.getTitle());
		System.out.println();
		System.out.println();
	}

	/**
	 * 3.신간 도서 리스트를 등록하는 메소드
	 * 
	 * @param booklist
	 *            : 추가할 도서 리스트
	 */
	public void addBookList(String fileName) {

		System.out.println();
		System.out.println("▶신간 리스트 입고◀");
		try (Scanner book = new Scanner(new File(fileName))){
			while(book.hasNextLine()){
				String readLine = book.nextLine().trim();
				String[] datas = readLine.split("/");
				books.add(new Book(datas[0],Integer.parseInt(datas[1])));
				System.out.println(datas[0]);
			}
			bookList.addAll(books);
			books.removeAll(books);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			printBookList();
		}
	}

	/**
	 * 4.검색한 도서의 가격정보를 출력하는 메소드
	 * 
	 * @param title
	 *            : 검색한 도서명
	 */
	public void printPrice(String title) {

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
				System.out.printf("▶검색하신 도서 : %s%n▶가격 정보 : %d%n",title,bookList.get(i).getPrice());
			}
			if(i==bookList.size()&&bookList.get(i).getTitle().equalsIgnoreCase(title)){
				System.out.printf("※검색하신 도서  %s이/가 존재하지 않습니다.",title);
				return;
			}
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * 5.원하는 책 목록을 삭제하는 메소드
	 * 
	 * @param title
	 */
	public void removeBook(String title) {
		for (int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equalsIgnoreCase(title)){
				bookList.remove(i);
			}
			if(i==bookList.size()-1&&bookList.get(i).getTitle().equalsIgnoreCase(title)){
				System.out.println("존재하지 않는 도서입니다.");
				return;
			}
		}
		System.out.printf("▶ %s 삭제 완료 ◀",title);
		printBookList();
	}

	/**
	 * 보유중인 도서의 가격 합계
	 */
	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < bookList.size(); i++) {
			sum += bookList.get(i).getPrice();
		}
		System.out.println("___________________________");
		System.out.printf("책 가격의 총합 :	%d%n",sum);
		System.out.println();
		System.out.println();
	}
	

}
