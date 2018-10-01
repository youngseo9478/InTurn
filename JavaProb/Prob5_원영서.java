package day6;

import java.util.Arrays;

public class Sorting_Selection {
	public static void main(String[] args) {
//		예외 대처 -> 인자를 아무것도 넘겨주지 않으면 입력을 요청함 (0을입력해도 상관없으나 아예 입력안했을 경우 예외발생)
		if(args.length==0){
			System.out.println("배열의 크기를 인자로 넘겨주세요");
			return; //return해줘야 에러메세지 안뜸..
		}
		
//		command로 배열 크기를 정하는 방법!
		int[] num = new int[Integer.parseInt(args[0])];
		int temp;
		num[0]=(int)(Math.random()*45+1);
		for (int i = 1; i < num.length; i++) {
			num[i]=(int)(Math.random()*45+1);
			for (int j = 0; j < i; j++) {
				if(num[j]==num[i]){
					i--;
					break;
				}
			}
		}
//		원본 보존 방법! 
//		num2=num; 하면 같은 주소를 가리키는 것이기 때문에 원본이 달라지게됨 (원본보존 X)
		int[] num2 = new int[num.length];
		System.arraycopy(num, 0, num2, 0, num.length);
//		for (int i = 0; i < num2.length; i++) {
//			num2[i]=num[i];
//		}
		System.out.print("정렬 전 : ");
		System.out.println(Arrays.toString(num));
		
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i]>num[j]){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
		System.out.print("정렬 후 : ");
		System.out.println(Arrays.toString(num));
		System.out.print("원본 : ");
		System.out.println(Arrays.toString(num2));
	}
}
