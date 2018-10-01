package com.ex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptDataInsert {

	public static void main(String[] args){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "java01";
		String password = "java01";
		
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null; 여기선 값읽어오는게아니라 써준거라서 ..
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,password);
			stmt = con.createStatement();
					
			/*둘다 제네릭한 형태가 아님! 넣어주는 값은 계속 다를텐데 일일이 쳐서 문장을 넣어주기는 번거로움*/
			String sql = "INSERT INTO dept (deptno,dname,loc)"+"VALUES (50,'개발','서울')";
			
			/*혹은 
			
			String deptStr = "60";
			String dnameStr = "해양부";
			String locStr = "부산";
			String sql = "INSERT INTO dept (deptno,dname,loc)"+"VALUES ("+deptStr+",'"+dnameStr+"','"+locStr+"')";*/
			
			//executeUpdate는 디비에 값을 추가해주는 것이기때문에 추가된 레코드 개수를 리턴해줌
			int n = stmt.executeUpdate(sql);
			System.out.println(n+" 개의 레코드가 저장되었습니다");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
