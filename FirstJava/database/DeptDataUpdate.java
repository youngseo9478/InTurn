package com.ex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptDataUpdate {
	public static void main(String[] args){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "java01";
		String password = "java01";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,password);
			
			String sql = "UPDATE dept SET dname = ?, loc = ?"+"WHERE deptno =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "인사");
			pstmt.setString(2, "서울");
			pstmt.setInt(3, 60);
			
			int n = pstmt.executeUpdate();
			System.out.println(n+" 개의 레코드가 수정");
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					pstmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}
}
