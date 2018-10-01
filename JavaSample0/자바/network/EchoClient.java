package network;
/***********SOCKET-CLIENT**************/
import java.io.*;
import java.net.*;

public class EchoClient {

	private String ip;
	private int port;
	private String str;
	BufferedReader file;
	
	public EchoClient(String ip, int port) throws IOException
	{
		this.ip = ip;
		this.port = port;
		Socket tcpSocket = getSocket();
		OutputStream os_socket = tcpSocket.getOutputStream();
		InputStream is_socket = tcpSocket.getInputStream();
		
		BufferedWriter bufferW = new BufferedWriter(new OutputStreamWriter(os_socket));
		BufferedReader bufferR = new BufferedReader(new InputStreamReader(is_socket));
		
		System.out.print("입력 : ");
		file = new BufferedReader(new InputStreamReader(System.in));
		
		str = file.readLine();
		str += System.getProperty("line.separator");
		
		bufferW.write(str);
		bufferW.flush();
		
		//서버로부터 입력된게 있을때까지 여기서 대기
		str = bufferR.readLine();
		System.out.println("Echo Result : " + str);
		
		file.close();
		bufferW.close();
		bufferR.close();
		tcpSocket.close();
	}
	
	public Socket getSocket(){
		Socket tcpSocket = null;
		try{
			//server의 ip,port 주소를 매개변수로 받아서 만든 소켓객체 생성
			//서버와 클라이언트가 소켓으로 연결되는 것
			tcpSocket = new Socket(ip,port);
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		return tcpSocket; //소켓객체를 던져줌
	}
	
	public static void main(String[] args) throws IOException
	{
		new EchoClient("localhost",3000);
	}
}
