package day27;

import java.util.Scanner;

public class ControllerEx6 {	//점수(0~100)를 입력받아서 학점주는 프로그램(switch case문 사용) 

	public static void main(String[] args)
	{
		System.out.println("점수를 입력해주세요 > ");
		
		Scanner sc = new Scanner(System.in);		//Scanner는 입력받은 값은 저장하는 ...
		int score = sc.nextInt();		//코드쓰면 뒤에코드 지워질때 insert키 누르면 해결~	
		
		switch(score)
		{
		case 100:		//자바에서는 case문 안에 조건문 들어갈 수 없다. case score>90: ->이런거 안된다.
		case 99:
		case 98:
		case 97:
		case 96:
		case 95:
			System.out.println("당신의 학점은 A입니다.");
			break;
		case 89: case 88: case 87: case 86:	case 85:  //이렇게 한줄에 쓰는 것도 가능하다.
			System.out.println("당신의 학점은 B입니다.");
			break;
		case 79:
		case 78:
		case 77:
		case 76:
		case 75:
			System.out.println("당신의 학점은 C입니다.");
			break;
		default:
			System.out.println("낙제");	
		}
			
	}
}
