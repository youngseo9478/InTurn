package day11_7;
/*ByteI/O와 다른 점은
 * 2byte짜리이고 
 * input output대신에 reader writer라고 쓰는 차이만 있음
 * 
 * 
 *파이프 입출력 스트림은 주로 멀티스레드 처리에 사용을 하는데, 하나의 스레드가 읽어 들인 내용을 다른 스레드에게 전달하고자 할 때 파이프스트림의 기능을 이용하는 것이다.
 *
 *1. PipedInputStream
 
PipedInputStream() : 아직 연결되지 않은 PipedInputStream을 생성.
PipedInputStream(PipedOutputStream src) : PipedOutputStream에 연결하는 PipedInputStream을 생성.
 
void connect(PipedOutputStream src) : PipedInputStream과 연결할 PipedOutputStream src를 지정
 
기본생성자를 이용해서 PipedInputStream을 생성한다면 반드시 이 함수를 사용해서 PipedOutputStream과 연결을 맺게 해야 한다.
 
2. PipedOutputStream
 
PipedOutputStream() : 아직 연결되지 않은 PipedOutputStream을 생성.
PipedOutputStream(PipedInputStream src) : PipedInputStream에 연결하는 PipedOutputStream을 생성합니다.
 
void connect(PipedInputStream snk) : PipedOutputStream과 연결할 PipedInputStream을 지정.
*/

import java.io.*;

public class PipedReaderWriterEx {

	public static void main(String[] args)
	{
		/*InputThread와 OutputThread라는 이름을 던져주며 객체를 생성해줌*/
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		//PipedReader와 PipedWriter를 연결한다. connect는 스레드 안에 있는 것. 그래서 스레드 안에서 또 다시 한번씩 연결해준 것.디테일!
		inThread.connect(outThread.getOutput());
		
		//둘다 실행시작되지만 동시다발적인게 아니라 output이 써야 input이 받아서 읽는 개념 =>동기화되어있음
		inThread.start(); //시작되면 스레드의 run()으로 가서 수행하게됨
		outThread.start();
	}//main
}


class InputThread extends Thread
{
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	InputThread(String name)
	{
		super(name); //Thread(String name);
	}
	
	public void run()
	{
		try{
			int data = 0;
			
			//inThread가 바로 시작되는게아님. 읽어올 값이 없기때문에 output에 의해 쓰여지는 순간 connect로 받아서 여기서 읽을 수 있게 됨
			while((data=input.read())!=-1)
			{
				//data를 받아서 문자열로 모아찍으려고 StringWriter의 객체로 만들어 놓았음
				sw.write(data); 
			}
			System.out.println(getName()+"received : "+sw.toString());
		}catch(IOException e){e.printStackTrace();}
	}//run
	

	public PipedReader getInput()
	{
		return input;
	}
	
	
	public void connect(PipedWriter output)
	{/**connect해서 input이 output을 받아오는 것**/
		try{
			input.connect(output);
		}catch(IOException e){e.printStackTrace();}
	}//connect
}

class OutputThread extends Thread
{
	PipedWriter output = new PipedWriter();
	
	OutputThread(String name){
		super(name); // Thread(String name)
	}
	
	public void run()
	{
		try{
			String msg = "Hello";
			System.out.println(getName()+" sent : "+msg);
			output.write(msg);
			output.close();
		}catch(IOException e){e.printStackTrace();}
	}//run
	
	public PipedWriter getOutput()
	{
		return output;
	}
	
	public void connect(PipedReader input)
	{
		try{
			output.connect(input);
		}catch(IOException e){e.printStackTrace();}
	}//connect
}