package day11_7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx {

	public static void main(String[] args)
	{
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try{
			//여기서도 역시 true값주면 이어쓰기, 안주면 덮어쓰기가 디폴트!
			fos = new FileOutputStream("c:/java_study/bufferOut.txt",true);
			bos = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream test 입니다.";
			bos.write(str.getBytes());
			//bos.flush() 요즘은 이거 안해줘도 값 가져올 수 있어서 생략 버전에 따라 다름주의!
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				//요즘 버전은 Output은 닫을 때 상위개체부터 닫아줘야한다.
				if (bos != null) bos.close();
				if (fos != null) fos.close();
				//if (bos != null) bos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
