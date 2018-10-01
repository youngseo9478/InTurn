package day11_7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*print문장처럼 사용할 수 있게 해주는 것 
 * 어떤데이터를 써도 문자열로 받는것 
 * =>객체 자체도 무겁고 다 문자열로 받기때문에 프로그램이 무거운 편 필요할때만 사용해야한다.
 * 이건 랩핑을 두번 해주게 되는 것.*/
public class PrintStreamEx {

	public static void main(String[] args)
	{
		//PrintStream에 버퍼를 넣으면 속도가 빨라지기 때문에 두번 랩핑한 것. 꼭 버퍼로 랩핑해야한느 것은 아니고 outputStream이면 뭐든 가능하긴 함
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try{
			fos = new FileOutputStream("c:/java_study/printStream.txt");
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos, true);
			
			ps.println("원영서");
			ps.println(1234);
			ps.println(true);
			ps.println('a');
		}catch(IOException e)
		{ e.printStackTrace();}
		finally
		{
			try{
				if(ps!=null) ps.close();
				if(bos!=null) bos.close();
				if(fos!=null) fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
