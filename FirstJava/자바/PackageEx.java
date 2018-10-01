package day3_7;
/*패키지
 * static import문
 * 
 * system.out. 치면 패키지에서 불러오는 것.
 * import static[package path.class name.*]
 * 이렇게 사용하면 out.print만해도딤
 * 가독성 떨어지기때문에 사전에 협의하고 
 * 하는 것*/

import static java.lang.Math.*;
import static java.lang.System.out;

public class PackageEx {

	public static void main(String[] args)
	{
		int i = (int)(random()*26+65);
		out.println((char)i);
	}
	
}
