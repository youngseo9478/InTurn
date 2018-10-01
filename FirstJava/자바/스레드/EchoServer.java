package network;
/***********SOCKET-SERVER*************
 * 실행할때는 서버를 먼저실행시킨다음에 클라이언트를 실행시켜야함*/

import java.io.*;
import java.net.*;

public class EchoServer {

	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverS;
	
	public EchoServer(int port)
	{
		try{
			/*클라이언트의 소켓을 서버에도 이식하는 과정으로
			 * 객체를 통으로 받아서 가져온다.*/ 
			serverS = new ServerSocket(port);
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		while(true)
		{
			try{
				System.out.println("클라이언트의 요청을 기다리는 중");
				Socket tcpSocket = serverS.accept();
				//accept()에서 대기하다가 클라이언트측에서 Write하는 순간 아래 코드들을 수행함
				
				System.out.println("클라이언트의 IP주소 : "+tcpSocket.getInetAddress().getHostAddress());
				
				//제대로 들어왔는지 확인하면서 들어온걸 읽은걸 받고, 쓴걸받고..함
				is = tcpSocket.getInputStream();
				os = tcpSocket.getOutputStream();
				
				//버퍼로 받아둠
				bufferR = new BufferedReader(new InputStreamReader(is));
				bufferW = new BufferedWriter(new OutputStreamWriter(os));
				
				//클라이언트로부터 받은 메세지를 읽어서 message에 저장
				String message = bufferR.readLine();
				System.out.println("수신 메세지 : "+message);
				
				//서버측에서 여기에다가 추가로 write해서 입력을 하게되면 클라이언트측에서는 read해서 읽게된다.
				message = message+", 추가된 내용"+System.getProperty("line.separator");
				
				bufferW.write(message); //서버에서 추가로 작성한 메세지를 붙여서 다시 클라이언트로 전달
				bufferW.flush();
				bufferR.close();
				bufferW.close();
				tcpSocket.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new EchoServer(3000);
	}
}
