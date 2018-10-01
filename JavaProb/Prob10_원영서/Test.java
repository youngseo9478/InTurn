package prob_inheitance;

public class Test_Inheritance {
	public static void main(String[] args) {
		
		Student s = new Student(200201);
		s.setName("홍길동");
		s.setAge(20);
		s.print();
		
		Teacher t = new Teacher("JAVA");
		t.setName("이순신");
		t.setAge(30);
		t.print();
		
		Employee e = new Employee();
		e.setDept("교무과");
		e.setAge(40);
		e.setName("유관순");
		e.print();
		
		
		
	}
}
