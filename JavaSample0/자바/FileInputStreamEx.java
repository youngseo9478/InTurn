package day11_7;
/*스캐너는 문자열 형태로 받아주는데 
 * byte는 배열로 받음 그리고 byte는 1바이트씩읽기때문에 한글은 입력못받음
 * 그래서사실 스캐너가 편함 .
 * 그냥 이렇게 한바이트씩 받는 방법도 있다는걸 알아두기
 * 실행결과는 아래와 같이 나올 것임*/
/******파일명 : c:/java_study/test.txt*****
*******hi everyone!!********************/
import java.io.*;
public class FileInputStreamEx {

	public static void main(String[] args)
	{
		FileInputStream fis = null;
		byte _read[] = new byte[100];
		byte console[] = new byte[100]; //한바이트씩 읽기위함
		
		try{
			System.out.print("파일명 : ");
			System.in.read(console); //한바이트씩 읽어옴 -> read()는 hasNext(),next() 둘의 기능을 모두 갖고있는 메소드.
			String file = new String(console).trim();
			fis = new FileInputStream(file); //캐릭터I/O면 여기가 FileReader로 바뀌는 차이만 있음~
			fis.read(_read,0,_read.length);//_read에다가 0에서부터 _read.length만큼을 읽겠단 뜻
			System.out.println(new String(_read).trim());
		}catch(FileNotFoundException fnfe){ //읽으려는 파일이 없을 경우의 예외처리 -> catch는 하위단위부터 잡아준다. 
			fnfe.printStackTrace();
		}catch(IOException ie){ //나머지 에러가 날 수 있는 경우의 예외처리->처음부터 큰걸로 잡으면 다 여기에 걸려버리고 세분화가 안됨.
			ie.printStackTrace();
		}finally{ //finally로 묶인건 꼭 실행해야 하는 것. 파일을 열었으면 꼭 닫아야함
			try{//그러나 그 파일이 없어졌을수도있음->try catch이용해서 예외처리해주어야함
				if(fis != null) fis.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
