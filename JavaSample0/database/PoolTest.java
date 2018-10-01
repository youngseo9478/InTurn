package com.ex.database;
import java.util.ArrayList;
public class PoolTest {

	public static void main(String[] args)
	{
		PoolDAO dao = new PoolDAO();
		ArrayList<ExDTO> list = dao.select();
		
		for(ExDTO dto : list)
		{
			int deptno = dto.getDeptno();
			String dname = dto.getDname();
			String loc = dto.getLoc();
			System.out.println(deptno+" "+dname+" "+loc);
		}
	}
}
