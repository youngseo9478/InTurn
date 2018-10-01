package day29;

import static java.lang.Math.*;	//수학에 관련된 이미 정의되어있는 함수들이 들어있는 것.
//import static java.lang.System.*;

public class MathMethodEX {

	public static void main(String[] args)
	{
		int x1 = 1, y1 = 1; //(1,1)
		int x2 = 2, y2 = 2; //(2,2)
		
		double c = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));	//글씨체가 다른건 **static**메소드라서 그런 것임!!
		double a =c*Math.sin(Math.PI/4); //45도
		double b =c*Math.cos(Math.PI/4);
		//double b = c * cos(toRadians(45))
		
		System.out.printf("a=%f%n",a);
		System.out.printf("b=%f%n",b);
		System.out.printf("c=%f%n",c);
		System.out.printf("angle=%f rad%n",Math.atan2(a, b));
		System.out.printf("angle=%f degree%n%n",Math.atan2(a, b)*180/Math.PI);
		
		System.out.printf("24*log10(2)=%f%n", 24*Math.log10(2));
		System.out.printf("53*log10(2)=%f%n", 53*Math.log10(2));
		
	}
	
}
