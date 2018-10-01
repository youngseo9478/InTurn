package graphicUI;
import java.awt.*;
public class MenuTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Frame with Menu");
		f.setSize(300,200);
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("File");
		MenuItem miNew = new MenuItem("New");
		MenuItem miOpen = new MenuItem("Open");
		Menu mOthers = new Menu("Others"); //Menu임을 주의(확장형태로 만들기 위함)
		MenuItem miExit = new MenuItem("Exit");
		
		mFile.add(miNew); //메뉴에 메뉴아이템들을 추가한다.
		mFile.add(miOpen);
		mFile.add(mOthers); //메뉴에 메뉴를 추가한다.(mFile안에 확장형태의 메뉴가 되는 것 ->메뉴아이템X, 메뉴O)
		mFile.addSeparator(); //메뉴 분리선을 넣는다.
		mFile.add(miExit);
		
		MenuItem miPrint = new MenuItem("Print...");
		MenuItem miPreview = new MenuItem("Print Preview");
		MenuItem miSetUp = new MenuItem("Print SetUp");
		
		mOthers.add(miPrint);
		mOthers.add(miPreview);
		mOthers.add(miSetUp);
		
		Menu mEdit = new Menu("Edit");
		Menu mView = new Menu("View");
		Menu mHelp = new Menu("Help");
		CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar"); //체크되고 풀리고가 되는 메뉴아이템을 만들기 위해 설정해준 것.
		mView.add(miStatusbar); //mView의 메뉴아이템(추가해주는 것)
		mb.add(mFile);	//MenuBar에 Menu를 추가한다.
		mb.add(mEdit);
		mb.add(mView);
		//mb.add(mOthers); mOthers를 확장형태로 말고 메뉴바에 바로 올리게끔 설정도 가능함.
		mb.add(mHelp);
		f.setMenuBar(mb); 
		f.setVisible(true);
	}
}
