package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class EmpManager {
	public static void main(String[] args) {
		EmpManager mgr = new EmpManager();
		String[] job = new String[2];
		job[0] = args[0];
		job[1] = args[1];
		mgr.printEmployee(job);
	}

	public void printEmployee(String jobs[]) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select employee_id,first_name, salary "
				+ "from employees e, jobs j "
				+ "where e.job_id = j.job_id and j.job_title in (?,?)";
		try {
			con = JDBCUtil.getConnection();// 目池记 肯己
			ps = con.prepareStatement(sql);
			ps.setString(1, jobs[0]);
			ps.setString(2, jobs[1]);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("employee_id") + ", ");
				System.out.print(rs.getString("first_name") + ", ");
				System.out.print(rs.getInt("salary"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 磊盔 馆吵 场
			JDBCUtil.close(rs, ps, con);
		}
	}
}
