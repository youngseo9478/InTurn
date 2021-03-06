package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.EducationalLevelVO;

public interface EducationalLevelDAO {
	public List<EducationalLevelVO> getUserEduLvl(String id);
	public int insertEduLvl(EducationalLevelVO vo);
	public int modifyEduLvl(EducationalLevelVO vo);
	public int deleteEduLvl(int eduLevel_num);
	public EducationalLevelVO getEduLvl(int eduLevel_num);

}
