package com.ex.database;

import java.util.ArrayList;

public class ExUseDAO {

	public static void main(String[] args)
	{
		//여기서 ExDAO 클래스 사용하려면 객체로 생성해줘야함!
		ExDAO dao = new ExDAO();
		
		//SELECT
		ArrayList<ExDTO> list = dao.select();
		
		for(ExDTO dto : list)
		{
			int deptno = dto.getDeptno();
			String dname = dto.getDname();
			String loc = dto.getLoc();
			System.out.println(deptno+" "+dname+" "+ loc);
		}
		
		//INSERT
		dao.insert(82,"PerfumeLab","seoul");
		for(ExDTO dto : list)
		{
			int deptno = dto.getDeptno();
			String dname = dto.getDname();
			String loc = dto.getLoc();
			System.out.println(deptno+" "+dname+" "+ loc);
		}
	}
}
