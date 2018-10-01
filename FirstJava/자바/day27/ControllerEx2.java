package day27;

public class ControllerEx2 {	// if조건문 확장 ->else if
	public static void main(String[] args)
	{
		int subjectNumber =94;
		 if(subjectNumber>90)
		 {
			 if(subjectNumber>97)	//if문 안에 if문도 가능하다 ->더세분화된 분기 지금은 2depth
			 {	//2depth이상은 안쓰는게 좋음 헷갈리고 한눈에 들어오지 않는다.
			 System.out.println("당신의 학점은 A+입니다.");
			 } 
			 else if(subjectNumber>93)
			 {
			 System.out.println("당신의 학점은 A0입니다.");
			 } 
			 else
			 {
			 System.out.println("당신의 학점은 A-입니다.");
			 } 
		}
		 else if(subjectNumber>80)
		 {
			 System.out.println("당신의 학점은 B입니다.");
		 }
		 else if(subjectNumber>70)
		 {
			 System.out.println("당신의 학점은 C입니다.");
		 }
		 else if(subjectNumber>60)
		 {
			 System.out.println("당신의 학점은 D입니다.");
		 }
		 else
		 {
			 System.out.println("당신의 학점은 F입니다.");
		 }	
	}
}
