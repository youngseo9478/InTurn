package day13.prob;

public class Rectangle extends Shape implements Resizable {

	double width;
	double height;

	/**
	 * 디폴트 생성자
	 */
	public Rectangle() {
		super();
	}

	/**
	 * 직사각형의 밑변과 높이를 초기화하는 생성자
	 * 
	 * @param width
	 * @param height
	 */
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
	 * 사각형의 넓이를 구하는 메소드
	 */
	@Override
	double getArea() {
		return width * height;
	}

	/**
	 * 사이즈를 변경하는 메소드
	 */
	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

}
