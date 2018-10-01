package day11_7;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//특정 데이터 형태로  써주는 게 DataOutputStream
public class DataOutputStreamEx {

	public static void main(String[] args)
	{
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try{
			fos = new FileOutputStream("sample.dat");
			//fos를 dos로 랩핑한 것
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			dos.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}
