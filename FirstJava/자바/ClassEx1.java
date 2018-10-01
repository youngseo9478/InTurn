package day28;
/*Class
 * 클래스란?
 * ex) String도 클래스 -> 자주사용해서 만들어놓았을뿐
 * */
public class ClassEx1 {

	public static void main(String[] args)
	{
		String[] arrStr = new String[3];
		
		arrStr[0]="안녕하세요";
		arrStr[1]="좋은 하루 되세요";
		arrStr[2]="반갑습니다";
		
		for(int i=0; i<arrStr.length;i++)
		{
			System.out.println(arrStr[i]);
		}
		
		String[] arrStr2 ={"hi","everyone"};
		
		for(int i=0; i<arrStr2.length; i++)
		{
			System.out.println(arrStr2[i]);
		}
	}
}
