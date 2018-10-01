package day11_7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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
