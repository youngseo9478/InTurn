
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class CalendarAWTEx extends Frame {

	Panel pDate = new Panel();
	Panel pUp = new Panel();

	Button btnPrevMon = new Button("<=");
	Button btnNextMon = new Button("=>");
	Label lblYearMon = new Label();

	Button[] btnArr = new Button[42];

	Calendar curMon = Calendar.getInstance();

	public CalendarAWTEx(String title) {
		super(title);
		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);
		pDate.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}
		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});
		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);
		setDays(curMon);
		setVisible(true);

	}

	void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		lblYearMon.setText(year + "년 " + (month + 1) + "월 ");
		Calendar sDay = Calendar.getInstance(); // 시작일
		// 1. (sDay) 1 . 시작일 을 해당 월의 일이 포함된 일요일로 설정한다
		sDay.set(year, month, 1); // 1 . 입력월의 일로 설정한다
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		// 2. sDay 1 . 반복문을 사용해서 의 값을 씩 증가시키면서 버튼에 날짜를 넣는다
		for (int i = 0; i < btnArr.length; i++, sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE); // sDay day 에서 날자를 뽑아서 에 저장
			btnArr[i].setLabel(day + "");
			// 3. (Color.white) 만일 날짜가 해당 월에 속하면 버튼의 배경색을 흰색 으로 하고 그렇지 않으면 밝은 회색
			// 으로 설정한다 (Color.lightGray) .
			if (sDay.get(Calendar.MONTH) != month) {
				btnArr[i].setBackground(Color.lightGray);
			} else {
				btnArr[i].setBackground(Color.white);
			}
		}
	} // setDays(Calendar date)

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button src = (Button) ae.getSource();
			if (src == btnPrevMon) {
				curMon.add(Calendar.MONTH, -1);
			} else if (src == btnNextMon) {
				curMon.add(Calendar.MONTH, 1);
			}
			setDays(curMon);
			repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalendarAWTEx("달력");
	}

}
