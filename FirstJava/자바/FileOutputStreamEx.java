package day11_7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) 
	{
	
		FileOutputStream fos = null;
		try{
			//이어쓰기 위해서는 두번째 매개변수(append)자리에 true를 넣어줘야한다.
			//그리고 기존의 있는 파일이아니더라도 예를들어 test2.txt해줘도 그 파일이 생성되고 데이터가 출력된다.
			fos = new FileOutputStream("c:/java_study/test1.txt",true);
			//("c:/java_study/test1.txt")-> 덮어쓰기. 
			String message = "Hello java";
			fos.write(message.getBytes());
			//fos.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				if (fos!=null) fos.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
