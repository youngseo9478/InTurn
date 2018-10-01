package graphicUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/******Dialog*******
 * 알림과 동의 confirm에 대한 것
 * 
 * Dialog(Dialog owner) 
 * -> owner는 Frame의 객체 
 * modal값이 true이면 앞에창뜬게 종료가되어야 뒤에있는게 사용가능
 *  ->꼭 사용자한테 confirm을 받아야하는건 Modal을 true로 꼭 설정해야한다. 
 * */
public class DialogEx1 {
	public static void main(String[] args)
	{
		Frame f = new Frame("Parent"); //info 다이얼로그를 처리하기 전에는 f 프래임을 건들 수 없다.
		f.setSize(300,200);
		
		//Parent Frame은 f로하고, modal값을 true로 해서 필수 응답 Dialog로 함.
		Dialog info = new Dialog(f,"Information",true); //true를 넣으면 modal이 지정되어 먼저 처리되어야 뒤에 있는 프레임을 건들 수 있다.뒤에프레임클릭하면 info프레임이 깜빡거린다.
		//Dialog info = new Dialog(f,"Information",true);//true자리에 아무것도 안넣으면 모달이 아닌 것. 우선순위없이 프레임아무거나 먼저 사용할 수 있음
		info.setSize(140,90);
		info.setLocation(50, 50); //parent frame이 아닌, 화면이 위치의 기준이 된다.
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog", Label.CENTER); //여기서는 이 메세지가 info 프레임의 가운데에 위치하게 된다.
		Button ok = new Button("OK"); //여기서는 info 프레임에 OK버튼을 추가했다.
		info.add(msg); //msg를 info에 추가한다.
		info.add(ok); //ok버튼을 info에 추가한다.
		
		f.setVisible(true);
		info.setVisible(true); //다이얼로그를 화면에 보이게 한다.
		
	}
}
