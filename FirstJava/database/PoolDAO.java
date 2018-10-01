package com.ex.database;
/***실무에서 사용하는 SELECT/INSERT방법은 Pool을 이용한 것***/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
public class PoolDAO {

	BasicDataSource ds;
	
	public PoolDAO(){
		ds = new BasicDataSource();
		/*드라이버를 이 형태로 랩핑해서 사용->모든정보를 베이직데이터소스에 담에서 사용하게 되는 것
		 * 커넥션을 일일이 사용할때마다 연결해줄 필요 없이
		 * 이렇게 랩핑해서 사용하면 커넥션을 미리 만들어 놓고 꺼내 쓸 수 있어서 좋음*/
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("java01");
		ds.setPassword("java01");
		//커넥션 4개까지도 만들 수 있는 것
		ds.setInitialSize(4);
	}
	
	//SELECT하면 여러개의 값이 출력되기 때문에 배열리스트 형태로 리턴
	public ArrayList<ExDTO> select(){
		ArrayList<ExDTO> list = new ArrayList<ExDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			/*커넥션을계속해서하고있음 비효율적 
			 * Connection Pool을 이용하면 효율적임
			 * 한번만 만들어서 뒀다 쓸 수 있는 것
			 * 주소값만 알면 계속 연결할 필요없이 한번만 연결해두면 됨
			 * 그리고 커넥션 여러개 만들수도있음
			 * 
			 * 이 것은 자바에서 지원하는 라이브러리가 아님
			 * http://jakarta.apache.org/에서 만들어 나온 라이브러리임!
			 * */
			
			//커넥션에 아까 랩핑해둔 드라이버를 통해 커넥션을 생성=>한번만 연결하면 된다는게 큰 장점
			con = ds.getConnection();
			String query = "SELECT * FROM dept";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ExDTO dto = new ExDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}//end select
}
