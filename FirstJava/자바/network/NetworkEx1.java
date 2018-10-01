package network;

import java.net.*;
import java.util.*;

public class NetworkEx1 {

	public static void main(String[] args)
	{
		//InetAddress 객체를 뽑아오는애
		InetAddress ip = null;
		//호스트에 대응하는 InetAddress 배열을 반환한다.
		//실제로 다음이나 네이버같은 큰 사이트는 서버가 여러개 그래서 배열로 받아오는 것
		//아이피나 호스트주소를 뽑아올 수 있음
		InetAddress[] ipArr = null;
		
		/* getByName() : 주어진 도메인네임을 통해서 IP주소를 반환한다.
		 * toString() : IP주소를 문자열로 변환하여 리턴해준다.
		 *  ->The string returned is of the form: hostname / literal IP address.
		 * 
		 * getAdress() : 디폴트로 정수(-128~127)범위를 갖는 주소값을 리턴함
		 *  ->그래서 음스로 나오는 경우가 발생 ->음수로 나온것만 +256해서 양의 값을 얻어보면
		 *    getHostAddress()와 같은 IP주소가 나옴을 확인할 수 있다.
		 *    
		 * Arrays.toString() : 배열에 저장된 값을 문자열 형태로 리턴할 때 사용하는 메소드
		 * ->The string representation consists of a list of the array's elements, enclosed in square brackets ("[]").
		 */
		try{
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress(); : "+ip.getHostAddress());
			System.out.println("toString(); " +ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress(); : "+Arrays.toString(ipAddr));
			
			String result = "";
			for(int i=0; i<ipAddr.length;i++)
			{
				// ()? a: b; =>소괄호안의 조건문이 맞으면(true) a를 수행하고 틀리면(false) b를 수행 
				result +=(ipAddr[i]<0)? ipAddr[i]+256:ipAddr[i];
				result +=".";
			}
			System.out.println("getAddress()+256 : "+result);
			System.out.println();
			//호스트를 못찾았을때 예외처리를 꼭 해주는 것이 좋다
		}catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}
		
		/*호스트(내가쓰는컴퓨터)의 이름과 주소를 알고싶을 때
		 * 
		 * getLocalHost() : 내가 사용하고 있는 컴퓨터의 주소를 반환한다.
		 * getHostName() : 호스트 컴퓨터의 이름을 반환한다.
		 * getHostAddress() : 문자열로 표현된 IP주소를 반환한다.*/
		try{
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress(); : "+ip.getHostAddress());
			System.out.println();
		} catch (java.net.UnknownHostException e) { //아래의 캐치문장이랑 같은것~ import어떻게시켜주냐에따라서 다르게!
			e.printStackTrace();
		}
		
		try{
			/*네이버와같은 서버는 IP주소를 여러개 가지고 있다.
			 * 
			 * getAllByName() : 매개변수로 받은 도메인이 갖고있는 IP주소를 모두 가져온다. 
			 * ipArr : InetAddress[]로 만든 객체로 주소를 배열형태로 받는다.  */
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			//접근가능한 공식적인 IP의 개수만큼 length가 잡힐 것.
			for(int i=0; i<ipArr.length; i++)
			{
				System.out.println("ipArr["+i+"] :"+ipArr[i]);
			}
		}catch (UnknownHostException e) { //import java.net.*;으로 몽땅 import해줘서 이렇게만 써도 오케이
			e.printStackTrace();
		}
	}
}
