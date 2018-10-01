package day13.prob;

public class ShapeTest {
	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(5, 6);
		RectTriangle rectTriangle = new RectTriangle(6, 2);

		// 부모타입 배열에 위에 생성한 두 객체 담기
		Shape[] shapes = { rectangle, rectTriangle };

		// shapes 배열에 담긴 객체들의 면적 각각 구해서 출력
		for (int i = 0; i < shapes.length; i++) {
			System.out.printf("area : %.1f%n", shapes[i].getArea());
			// 리사이징이 가능한 객체는 new area를 한번 더 구해서 출력
			if (shapes[i] instanceof Resizable) {
				((Resizable) shapes[i]).resize(0.5);
				System.out.printf("new area : %.1f%n", shapes[i].getArea());
			}
		}
	}
}
