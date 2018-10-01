package network;
import java.net.*;
import java.io.*;
import java.util.*;
public class UrlConnectionEx {

	public static void main(String[] args)
	{
		URL url = null;
		try {
			url = new URL("http://www.ietf.org/rfc/rfc2068.txt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		URLConnection urlCon = null;
		try {
			urlCon = url.openConnection();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			urlCon.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String,List<String>> map = urlCon.getHeaderFields();
		Set<String> s = map.keySet();
		Iterator<String> iterator = s.iterator();
		
		while(iterator.hasNext())
		{
			String name = iterator.next();
			System.out.print(name+" : ");
			List<String> value = map.get(name);
			for(String _temp : value)
				System.out.println(_temp);
		}
		
		int len = urlCon.getContentLength();
		System.out.println("문서의 길이 : "+len+"바이트");
		if(len>0)
		{
			InputStream input = null;
			try {
				input = urlCon.getInputStream();
				
				System.out.println("===문서의 내용===");
				int readByte;
					while(((readByte = input.read())!=-1)&&(--len>0))
					{
						System.out.print((char)readByte);
					}
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("내용이없음");
		}
	}
}
