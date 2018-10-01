package day7;

public class Prob1 {
	public static void main(String args[]) {
		Prob1 prob1 = new Prob1();
		
		System.out.println( prob1.leftPad("SDS", 6, '#') );
		System.out.println( prob1.leftPad("SDS", 5, '$') ); 
		System.out.println( prob1.leftPad("SDS", 2, '&') ); 
	}
	public String leftPad(String str, int size, char padChar) {
		if(str.length()>=size){
			System.out.println(str);
		}
		else{
			for (int i = 0; i < size-str.length(); i++) {
				System.out.print(padChar);
			}
			System.out.print(str);
		}
		return "";
	}
}
