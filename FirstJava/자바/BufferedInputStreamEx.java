package day11_7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamEx {

	public static void main(String[] args)
	{
		FileInputStream fis = null;
		BufferedInputStream bis = null; //fis 객체를 받아섯 bis를 만들거라 FileInputStream이 필요한 것
		
		try{
			fis = new FileInputStream("c:\\java_study/test.txt");//둘이 같은 것("c:/java_study/test.txt");
			bis = new BufferedInputStream(fis); //FileInputStream의 객체를 받아서 버퍼형태스트림으로 만든다.
			int readbyte = 0;
			while((readbyte = bis.read())!=-1) //-1이 되는 건 더이상 읽어올 데이터가 없다는 뜻! read()함수는 읽을게 없으면 -1리턴함
			{
				System.out.print((char)readbyte); //문자로 받기위해서 char로 캐스팅 해줌
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				if(fis != null) fis.close(); //fis도 닫고
				if(bis != null) bis.close(); //fis를 참조해서 만든 bis도 닫아줘야함
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
