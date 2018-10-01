package day13.prob;

public class RectTriangle extends Shape {
	double width;
	double height;

	/**
	 * 디폴트 생성자
	 */
	public RectTriangle() {
		super();
	}

	/**
	 * 직각삼각형의 밑변과 높이를 초기화하는 생성자
	 * 
	 * @param width
	 * @param height
	 */
	public RectTriangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
	 * 직각삼각형의 넓이를 구하는 메소드
	 */
	@Override
	double getArea() {
		return width * height * (0.5);
	}

}
