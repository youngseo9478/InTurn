package com.ex.database;

import java.sql.*;
/********디비로부터 데이터를 읽어오는 방법************/
public class DaptDataSelect {
	
	public static void main(String[] args)
	{
		/*드라이버는 이미 정해진 uri이므로 틀리면 안됨. 외부에서 가져오는 경우는 모두 문자열로 받기때문에 
		 * 에디터가 오류 잡아줄 수 없음 !! ***주의****/
		String driver = "oracle.jdbc.driver.OracleDriver";
		/*로컬호스트 아이피는 127.0.0.1인데 만약 다른컴퓨터에 있는 디비를 사용하려면 그 아이피를 넣어줘야함
		 *1521은 포트번호인데 디비를 외부에서 가져올 때의 포트번호로 이미 정해진 값
		 *우리가 사용하는 오라클은 EXPRESS이기때문에 xe 이또한 사용하는 프로그램에 따라 정해진 값*/
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//우리가 만들어준 '서브'계정의 아이디와 비밀번호
		String userid = "java01";
		String password = "java01";
		
		/*디비와 자바 연동하는 순서
		 * 1.import java.sql.*; 해주기
		 * 2.드라이버 로드
		 * 3.JDBC를 이용해 연결 (Connection 객체 생성)
		 * 4.자바에서 친 쿼리문을 디비에 넘겨주기 위해 Statement 객체 생성
		 * 5.디비에서 읽은 데이터를 자바에 전해주기 위해 ResultSet 객체 생성
		 * 
		 * 일단 객체 선언만 해놓은 상태*/
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			/*객체를 생성하는 방법은 2가지 하나는 new쓰는것이고 하나는 아래와 같은 방법(Class.forName)
			 * driver에 넣어놨던 루트를 통해 드라이버객체를 로드시키고*/
			Class.forName(driver);
			/*getConnection을 통해 url을 연결*/
			con = DriverManager.getConnection(url,userid,password);
			//Statement객체는 Connetion에 포함된 것이므로 con.~~해서 Statement 객체를 생성한다
			stmt = con.createStatement();
			
			//디비에서 실행시킬 쿼리문
			String query = "SELECT deptno, dname, loc FROM dept";
			
			//Statement객체를 통해 쿼리문을 디비로 넘겨준후 디비로부터 추출된 데이터를 ResultSet로 넘겨주어 객체를 생성
			rs = stmt.executeQuery(query);
			
			//next()는 현재 커서 다음에 데이터가 있는지 없는지 T/F값 리턴
			while(rs.next())
			{
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.println(deptno+" "+dname+" "+loc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{//파일할때와 마찬가지로 데이터베이스를 이용할때도 열었으면 꼭 닫아줘야함
			try{
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}
