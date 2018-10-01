package network;
import java.net.*;
import java.io.*;
/*검색할 주소 예시
 * http://www.daum.net?:8080/main/sub.jsp?id=lee (실제로있는거건들면 안먹힘...)*/
public class UrlEx1 {

	public static void main(String[] args) throws Exception
	{
		String urlstr = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("URL 페이지 입력==>");
		urlstr = reader.readLine().trim();
		URL url = new URL(urlstr);
		System.out.println("프로토콜 : "+url.getProtocol());
		System.out.println("포트번호 : "+url.getPort());
		System.out.println("호스트 : "+url.getHost());
		System.out.println("URL 내용 : "+url.getContent());
		System.out.println("파일경로 : "+url.getPath());
		System.out.println("URL 전체 : "+url.toExternalForm());
	}
}
