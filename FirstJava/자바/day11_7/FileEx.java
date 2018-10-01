package day11_7;

import java.io.File;
import java.io.IOException;

/*C드라이브에는 파일을 함부로 생성할 수 없게끔 막혀있는경우가 많은데
 * 이를 해결하는 방법은 해킹과 관련이 있기때문에 지금은 그냥 
 * 막혀서 에러가 난다는 것 정도만 알고 있기*/
public class FileEx {

	public static void main(String[] args) throws IOException
	{
		String filePath = "c:\\";
		File f1 = new File(filePath);
		String list[] = f1.list();
		for(int i = 0; i<list.length; i++)
		{
			File f2 = new File(filePath, list[i]);
			if(f2.isDirectory())
			{
				System.out.printf("%s : 디렉토리 %n",list[i]);
			}
			else
			{
				System.out.printf("%s : 파일 (%,dbyte)%n", list[i], f2.length());
			}
		}
		
		File f3 = new File("c:\\java_study\test.txt");
		//System.out.println(f3.createNewFile());
		System.out.println(f3.getAbsolutePath());
		//System.out.println(f3.getCannoicalPath());
		System.out.println(f3.getPath());
		System.out.println(f3.getName());
		System.out.println(f3.getParent());
		File f4 = new File("c:\\java_study\test.txt");
		File f5 = new File("c:\\java_study\test1.txt");
		System.out.println(f4.renameTo(f5));
	}
}
