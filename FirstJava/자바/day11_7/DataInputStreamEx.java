package day11_7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//기본데이터타입처럼 읽어올 수 있게끔 해주는 것.=>중요한건 파일이 이 형식으로 저장되어있어야 읽을 수 있음(범용적이지않음)
//넣어준 데이터 형태로 읽어오는게 DataInputStream
public class DataInputStreamEx {
	public static void main(String[] args)
	{
		try{
			FileInputStream fis = new FileInputStream("sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			
			dis.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}//main
}
