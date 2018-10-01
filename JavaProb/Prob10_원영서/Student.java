package prob_inheitance;

public class Student extends Person {

	private int id;
	
	public Student(int id) {
		super();
		this.id = id;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 학생 정보를 출력하기위한 메소드
	 */
	public void print(){
		System.out.printf("이름 : %s  나이 : %d  학    번 : %d%n",super.getName(),super.getAge(),id);
	}
	
}
