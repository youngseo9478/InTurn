package graphicUI;
import java.awt.*;
import java.awt.event.*;

public class TotalGraphicsTechEx extends Frame implements ActionListener{
	
	Point first_point, last_point, old_point;
	MenuItem menu_tool_pen, menu_tool_line, menu_tool_circle, menu_tool_rect;
	String str="펜"; //초기값은 펜으로 해놓은 것  
	
	public TotalGraphicsTechEx() {

		super("Graphics 테스트");
	
		//우선 메뉴바를 만들기 위해 메뉴바 객체를 생성
		MenuBar mb = new MenuBar();

		//메뉴바에 "도구"라는 메뉴를 추가하기위해 메뉴 객체를 생성
		Menu menu_tool = new Menu("도구");

		//메뉴 안에는 메뉴아이템들이 있는데 위에서 미리 선언해둔 메뉴아이템객체들에게 메뉴아이템이름을 대입해준다.
		menu_tool_pen = new MenuItem("펜");
		menu_tool_line = new MenuItem("선");
		menu_tool_circle = new MenuItem("원");
		menu_tool_rect = new MenuItem("사각형");
		
		//도구라는 메뉴에 펜,선,원,사각형 등의 메뉴 아이템을 추가해준다.
		menu_tool.add(menu_tool_pen);
		menu_tool.add(menu_tool_line);
		menu_tool.add(menu_tool_circle);
		menu_tool.add(menu_tool_rect);

		//메뉴바에 메뉴를 추가해준다.
		mb.add(menu_tool);
		//프레임에 메뉴바를 추가해준다.
		setMenuBar(mb);

		//BorderLayout에서 5가지 영역이 있는데 Center를 제외하고 다른영역들에 아무것도 넣지 않으면 Center가 그 영역을 모두 차지한다. 
		add(new GrimPanCanvas(), BorderLayout.CENTER);
		
		//위치와 크기를 동시에 설정해주는 메소드
		setBounds(200,200,400,400);
		
		//화면에 나타냄
		setVisible(true);
		
		//각각의 메뉴아이템에 대해 이벤트가 발생하면 이벤트 리스너가 정보를 수집해서 actionListener의 핸들러 메소드로 던져주는 것
		//this ->내부참조하고 있으므로 자기자신객체의 주소값을 가리킴 (implements해놓았기때문에 아래서 사용하려는 메소드를 오버라이딩해서 사용한다.)
		//actionPerformed()로 보내짐
		menu_tool_pen.addActionListener(this);
		menu_tool_line.addActionListener(this);
		menu_tool_circle.addActionListener(this);
		menu_tool_rect.addActionListener(this);
		
	}

	//메뉴아이템의 이벤트를 정보를 받아서 이벤트를 처리하는 핸들러메소드! (오버라이딩)
	public void actionPerformed(ActionEvent ae){
		//ae는 리스너가 수집한 이벤트에대한 정보 ->getSource()를 이용해 값을 가져오는데 리턴타입이 오브젝트이기때문에 캐스팅해서 받음
		MenuItem selected_menu = (MenuItem)ae.getSource();
		
		if(selected_menu.equals(menu_tool_pen)){
			str = menu_tool_pen.getLabel(); //getLabel()해서 해당하는 메뉴아이템의 이름을 가져오는 것
		}else if(selected_menu.equals(menu_tool_line)){
			str = menu_tool_line.getLabel();
		}else if(selected_menu.equals(menu_tool_circle)){
			str = menu_tool_circle.getLabel();
		}else if(selected_menu.equals(menu_tool_rect)){
			str = menu_tool_rect.getLabel();
		}
	}

	public static void main(String[] args) {
		new TotalGraphicsTechEx();
	}

	class GrimPanCanvas extends Canvas implements MouseMotionListener, MouseListener{

		public GrimPanCanvas() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		//Adapter를 쓰지 않아서 일일이 사용안하는 메소드들도 빈괄호 형태로라도 선언해놓았다.
		public void mouseClicked(MouseEvent me){}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}

		//마우스를 눌렀을 때
		public void mousePressed(MouseEvent me){
			first_point = me.getPoint(); //마우스의 현재 포인트를 받아서 첫번째 포인트에 값을 대입해준다. (Point타입 객체) 
			old_point=me.getPoint(); //누른상태에서 마지막 포인트
		}

		//마우스를 뗐을 때
		public void mouseReleased(MouseEvent me){
			last_point = me.getPoint(); //현재 포인트를 받아서 마지막포인트에 값을 대입해준다. 
			repaint(); //마우스를 뗐으면 이제 새로운포인트에서 새로 그릴 수 있도록 해주는 메소드
		}	
		
		//마우스를 드래그했을 때 (마우스모션이벤트에 해당)
		public void mouseDragged(MouseEvent me){
			last_point = me.getPoint();//드래그의 마지막 포인트를 대입받는다.
			repaint(); //역시 드래그가 끝나는 시점부터 다시 새로 그릴 수 있게 해준다.
		}

		public void mouseMoved(MouseEvent me){}

		// paint()메소드가 실행되서 캔버스에 그림이 그려짐
		public void update(Graphics g){
			paint(g);
		}
		
		//프레임 클래스에는 paint()라는 그림을 그리는 메소드가 정의되어있음 (오버라이딩)
		public void paint(Graphics g) {	
			if(first_point != null && last_point != null) {//아무것도 안한상태 (클릭조차도안한상태)
				if(str.equals("펜")) {
					//라인을 그리는 메소드 (초기x,y ,마지막 x,y)
					g.drawLine(first_point.x, first_point.y,
						last_point.x, last_point.y);
					first_point=last_point; //그림그리는게 끝났으면 드래그의 마지막위치가 첫번째 위치가된다.

					return;
				}
				if(str.equals("선")) {
					g.setColor(Color.CYAN); //흰색으로 되어있을때는 뭔지 몰랐음 ㅎㅎ
					g.drawLine(first_point.x, first_point.y,
						old_point.x, old_point.y); 
					//누른상태의 끝지점이므로->실행해서 선그리고 왔다갔다해보면 뭔지 알 수 있음.

					g.setColor(Color.BLACK);
					g.drawLine(first_point.x, first_point.y,
						last_point.x, last_point.y); //드래그중의 마지막 포인트
				}else if(str.equals("원")) {		
					g.setColor(new Color(255,255,255));//RGB를 똑같은 값으로 줘서 결국 하얀색
					//드래그하는동안의 포인트가 남아있어서 그런거고 이걸 하얀색으로 처리해줘야 동그라미만 보임
					g.fillOval(first_point.x, first_point.y, 
						old_point.x-first_point.x, 
						old_point.y-first_point.y);

					g.setColor(new Color(250,150,250));	//B값만 있으므로 파란색(250이 최대값이고 숫자가 클수록 채도가 높다				
					g.fillOval(first_point.x, first_point.y, 
						last_point.x-first_point.x, 
						last_point.y-first_point.y);
					
				}else if(str.equals("사각형")) {		
					
					//드래그를 하면서 크기를 키우고 줄이고를 할 수 있는데 이 드래그값이 다 나타나면 최종적으로 뭘만든건지 볼 수가 없어서
					//드래그로 왔다갔다하는 부분은 하얀색으로 채워서 안보이게 해준것!
					g.setColor(new Color(255,255,255));					
					g.fillRect(first_point.x, first_point.y, 
						old_point.x-first_point.x, 
						old_point.y-first_point.y);
					

					g.setColor(new Color(20,250,200));					
					g.fillRect(first_point.x, first_point.y, 
						last_point.x-first_point.x, 
						last_point.y-first_point.y);
				}
				old_point=last_point;
			}
		}
	}
}