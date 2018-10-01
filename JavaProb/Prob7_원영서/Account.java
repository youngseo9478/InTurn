package util;

public class Account {

	String name;
	String account;
	int balance;

	public Account() {
		this("OOO", "XXXXXX-XX-XXXXXX", 0);
	}

	public Account(String name, String acount, int balance) {

		this.name = name;
		this.account = acount;
		this.balance = balance;

	}

	public void deposit(int money) {

		if (money > 0) {
			this.balance += money;
			System.out.printf("========================================\n");
			System.out.printf("%d원이 입금되었습니다.\n", money);
			System.out.printf("거래 후 잔액 : %d원\n", this.balance);
			System.out.printf("========================================\n");
		} else {
			System.out.println("잘못된 금액입니다. 다시 입력해주세요.");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			this.balance -= money;
			System.out.printf("========================================\n");
			System.out.printf("%d원이 출금되었습니다.\n", money);
			System.out.printf("거래 후 잔액 : %d원\n", this.balance);
			System.out.printf("========================================\n");
		} else {
			System.out.println("잔고 부족입니다.");
			System.out.printf("현재 고객님의 잔고는 %d원 입니다.\n ", this.balance);
		}
	}

	public void transfer(String who, int money) {
		if (money <= balance) {
			this.balance -= money;
			System.out.printf("========================================\n");
			System.out.printf("%s님 계좌로부터  %s님 계좌로 %d원이 입금되었습니다.\n", this.name, who, money);
			System.out.printf("거래 후 잔액 : %d원\n", this.balance);
			System.out.printf("========================================\n");
		}
		else{
			System.out.println("잔고 부족입니다.");
			System.out.printf("현재 고객님의 잔고는 %d원 입니다.\n ", this.balance);			
		}
	}

	public void accountInfo() {
		System.out.printf("=========== %s님 계좌 정보 ==========\n", name);
		System.out.printf("예금주명 : %s\n계좌번호 : %s%n잔고 : %d%n", name, account, balance);
		System.out.printf("========================================\n");

	}
}
