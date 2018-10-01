package day3_7;
/*예외처리는 굉장히 무거운편 ->처리를 한 곳에 몰아놓고 하는 경우가 많음
 * throw vs throws
 * 
 * throws: 에러가 발생하면 나를 부른애한테 가서 처리하라고 하는 것. =>책임전가
 * 
 *   에러가 발생하면 try catch문장이 있는지 찾고 없으면 나를 호출한 곳으로 가서 에러를 처리하라고 떠맡김 ->처리하는 곳이 나오면 책임전가 끝*/ 
import static java.lang.System.out;
public class Throws1 {

	public void setData(String n) throws NumberFormatException{
		if(n.length()>=1){ //문자열이 입력되어졌는지 확인하는 것.
			String str = n.substring(0,1);// 0번째부터 1번째 즉 앞에서 한 글자를 자르는 것
			printData(str);//abc넣었으니까 자르면 a가 들어감
		}
	}
	public void printData(String n) throws NumberFormatException{
		int dan = Integer.parseInt(n); //a가 들어갔기 때문에 에러가 발생할 것 throw new NumberFormatException(); 이 객체가 생성되는 것 생략되어있음
		out.println(dan+"단");
		out.println("-----------------");
		for(int i=0; i<9; i++){
			out.println(dan+"*"+(i+1)+"="+(dan*(i+1)));
		}
	}
	
	public static void main(String[] args) {
		Throws1 t1 = new Throws1();
		try{
			t1.setData("abc"); //숫자가 아닌 문자가 들어감
		}catch(Exception e){
			out.println("첫 문자가 숫자가 아닙니다.");
		}
	}
}
