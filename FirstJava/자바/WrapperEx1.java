package day29;
/*Wrapper Class
 * int -> Integer
 * float -> Float
 * double -> Double
 * 기본데이터 타입의 첫번째 글자가 대문자로 표현된다.
 * 기본데이터 타입의 클래스로 랩핑해서 덩어리는 크지만 여러가지 활용이 되도록 해놓은것*/
public class WrapperEx1 {

	public static void main(String[] args)
	{
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i==i2?"+(i==i2));
		System.out.println("i.equals(i2)?"+i.equals(i2));
		System.out.println("i.compareTo(i2)="+i.compareTo(i2));
		System.out.println("i.toString()="+i.toString());//toString()은 Returns a String object representing this Integer's value.
		
		/*	parseInt(String s)
			Parses the string argument as a signed decimal integer.
			parseInt(String s, int radix)
			Parses the string argument as a signed integer in the radix specified by the second argument.
		*/
		System.out.println("MAX_VALUE="+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE="+Integer.MIN_VALUE);
		System.out.println("SIZE="+Integer.SIZE+"bits");
		System.out.println("BYTEsS"+Integer.BYTES+"bytes");
		System.out.println("TYPE="+Integer.TYPE);
	}
}
