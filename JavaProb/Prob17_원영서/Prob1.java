package day20.prob;

import java.util.Vector;

public class Prob1 {
	public static void main(String[] args) {
		String[] datas = {
				"도","레","미","파","솔"
		};
		
		System.out.println(moveToVector(datas).toString());
	}
	
	static Vector<String> moveToVector(String datas[]){
		Vector<String> v = new Vector<String>();
		for (int i = datas.length-1; i >=0; i--) {
			v.add(datas[i]);
		}
		return v;
	}
}
