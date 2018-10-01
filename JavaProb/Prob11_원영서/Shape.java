package day12.prob;

public abstract class Shape {
	
	protected double area;
	private String name;
	public Shape() {
		super();
	}
	public Shape(String name) {
		setName(name); 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void calculationArea();
	
	public void print() {
		System.out.printf("%s의 면적은 %f",getName(),area);
		System.out.println();
	}
}
